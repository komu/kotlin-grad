package kotlingrad

import kotlin.random.Random

class Neuron(nin: Int, private val nonLinear: Boolean = true) {

    private val w = List(nin) { Value(Random.nextDouble(-1.0, 1.0)) }
    private val b = Value(0.0)

    operator fun invoke(x: List<Value>): Value {
        assert(x.size == w.size)

        val act = (w dot x) + b

        return if (nonLinear) act.relu() else act
    }

    val parameters: List<Value>
        get() = w + b

    override fun toString() =
        "${if (nonLinear) "ReLU" else "Linear"}Neuron(${w.size})"
}

class Layer(nin: Int, nout: Int, nonLinear: Boolean = true) {

    private val neurons = List(nout) { Neuron(nin, nonLinear) }

    operator fun invoke(x: List<Value>): List<Value> =
        neurons.map { it(x) }

    val parameters: List<Value>
        get() = neurons.flatMap { it.parameters }

    override fun toString() =
        "Layer of [${neurons.joinToString { it.toString() }}]"
}

class MLP(nin: Int, nouts: List<Int>) {

    private val layers = run {
        val sizes = listOf(nin) + nouts
        List(nouts.size) { i ->
            Layer(sizes[i], sizes[i + 1], nonLinear = i != nouts.lastIndex)
        }
    }

    operator fun invoke(x: List<Value>): List<Value> =
        layers.fold(x) { v, l -> l(v) }

    val parameters: List<Value>
        get() = layers.flatMap { it.parameters }

    fun zeroGrad() {
        for (p in parameters)
            p.grad = 0.0
    }

    override fun toString() =
        "MLP of [${layers.joinToString { it.toString() }}]"
}
