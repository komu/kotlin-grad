package kotlingrad

import kotlin.math.pow

abstract class Value(
    var data: Double,
    private val children: List<Value>,
    private val op: String,
) {
    var grad = 0.0

    protected abstract fun doBackward()

    operator fun plus(rhs: Value): Value {
        val lhs = this

        return object : Value(lhs.data + rhs.data, children = listOf(lhs, rhs), op = "+") {
            override fun doBackward() {
                lhs.grad += grad
                rhs.grad += grad
            }
        }
    }

    operator fun times(rhs: Value): Value {
        val lhs = this

        return object : Value(data = lhs.data * rhs.data, children = listOf(lhs, rhs), op = "*") {
            override fun doBackward() {
                lhs.grad += rhs.data * grad
                rhs.grad += lhs.data * grad
            }
        }
    }

    fun pow(x: Double): Value {
        val self = this
        return object : Value(data = self.data.pow(x), children = listOf(self), op = "f'**$x") {
            override fun doBackward() {
                self.grad += (x * self.data.pow(x - 1)) * grad
            }
        }
    }

    fun relu(): Value {
        val self = this
        return object : Value(data = self.data.coerceAtLeast(0.0), children = listOf(self), op = "ReLU") {
            override fun doBackward() {
                self.grad += if (data > 0.0) grad else 0.0
            }
        }
    }

    fun backward() {
        val topo = mutableListOf<Value>()
        val visited = mutableSetOf<Value>()

        fun buildTopo(v: Value) {
            if (visited.add(v)) {
                for (c in v.children)
                    buildTopo(c)

                topo += v
            }
        }

        buildTopo(this)

        grad = 1.0
        for (v in topo.asReversed())
            v.doBackward()
    }

    override fun toString(): String =
        "Value(data=$data, grad=$grad, op=$op)"

    companion object {
        operator fun invoke(value: Double): Value = object : Value(value, emptyList(), "") {
            override fun doBackward() {
            }
        }
    }
}

operator fun Value.plus(rhs: Int): Value = this + rhs.toDouble()
operator fun Int.plus(rhs: Value): Value = rhs + this
operator fun Value.plus(rhs: Double): Value = this + Value(rhs)
operator fun Double.plus(rhs: Value): Value = rhs + this

operator fun Value.times(rhs: Double): Value = this * Value(rhs)
operator fun Double.times(rhs: Value): Value = rhs * this
operator fun Int.times(rhs: Value): Value = toDouble() * rhs
operator fun Value.times(rhs: Int): Value = this * rhs.toDouble()

operator fun Value.unaryMinus(): Value = this * -1.0

operator fun Value.minus(rhs: Value): Value = this + -rhs
operator fun Value.minus(rhs: Double): Value = this + -rhs
operator fun Double.minus(rhs: Value): Value = this + -rhs

operator fun Value.div(rhs: Value): Value = this * rhs.pow(-1)
operator fun Value.div(rhs: Double): Value = this * (1 / rhs)
operator fun Value.div(rhs: Int): Value = this / rhs.toDouble()
operator fun Double.div(rhs: Value): Value = Value(this) / rhs

fun Value.pow(power: Int) = pow(power.toDouble())

inline fun <T> Iterable<T>.sumOf(selector: (T) -> Value): Value {
    var sum = Value(0.0)
    for (v in this)
        sum += selector(v)
    return sum
}

fun Iterable<Value>.sum(): Value =
    sumOf { it }

infix fun List<Value>.dot(rhs: List<Value>): Value =
    indices.sumOf { this[it] * rhs[it] }
