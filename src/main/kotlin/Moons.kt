package kotlingrad

private object MoonsDataSet {
    val X = listOf(
        listOf(1.25314418, -0.48119382),
        listOf(-0.48876567, 0.95489841),
        listOf(-1.09558947, -0.02894222),
        listOf(-0.56520435, 0.67845468),
        listOf(-0.82471445, 0.39281925),
        listOf(-0.80391675, 0.42685549),
        listOf(0.54595384, 0.7250937),
        listOf(-0.80652002, 0.61724995),
        listOf(0.71361541, 0.48261971),
        listOf(1.94011566, 0.09554995),
        listOf(1.92103851, 0.26510868),
        listOf(0.13408887, -0.32583275),
        listOf(0.54651907, -0.43266413),
        listOf(0.23158312, -0.21967126),
        listOf(-0.94507704, 0.4125231),
        listOf(0.85753689, -0.43710368),
        listOf(-0.04215595, 0.94365396),
        listOf(0.73460746, 0.62576195),
        listOf(0.1889991, 0.09047504),
        listOf(-0.82096794, 0.56539176),
        listOf(1.80652613, -0.12799191),
        listOf(0.22457793, 0.10941718),
        listOf(1.37354241, -0.62528473),
        listOf(-0.10115708, 0.37323469),
        listOf(-0.46374251, 0.73740659),
        listOf(0.64863834, -0.47823203),
        listOf(-0.07776005, 0.95763419),
        listOf(1.00304353, -0.49197444),
        listOf(0.04105791, 0.53041644),
        listOf(1.08281705, -0.60734326),
        listOf(-0.54009039, 0.98587778),
        listOf(1.0349321, 0.21640077),
        listOf(-0.86385383, 0.29849622),
        listOf(0.16376876, 0.15545235),
        listOf(1.38957809, -0.30673702),
        listOf(2.05604557, 0.52064324),
        listOf(-0.57458791, 0.80295913),
        listOf(0.47307103, 0.08505595),
        listOf(1.45617203, -0.54623482),
        listOf(0.26382506, 0.95900985),
        listOf(1.01917184, 0.37427255),
        listOf(1.8191285, -0.1109515),
        listOf(0.21613736, 0.9244368),
        listOf(1.11377435, -0.4457112),
        listOf(0.61811222, 0.30925365),
        listOf(1.49432712, -0.2604334),
        listOf(-0.68557167, 0.76203732),
        listOf(-0.04111182, 1.02881702),
        listOf(-0.59281942, 0.74072419),
        listOf(-1.0247433, 0.32944536),
        listOf(0.32676698, -0.19144109),
        listOf(0.52494457, 0.92383649),
        listOf(1.85706172, -0.33969135),
        listOf(0.20306713, 0.02889224),
        listOf(0.51210858, -0.30735069),
        listOf(-0.00902376, 0.98869052),
        listOf(-0.65469374, 0.75447458),
        listOf(-0.10976193, 0.1500703),
        listOf(0.90228415, -0.52139449),
        listOf(1.46418311, -0.25687398),
        listOf(0.7151646, -0.55910061),
        listOf(2.10011992, 0.30382929),
        listOf(0.67648645, 0.73034389),
        listOf(1.73099547, -0.343922),
        listOf(1.77831199, 0.08912925),
        listOf(0.53595634, -0.35029613),
        listOf(0.96939103, 0.16782452),
        listOf(-0.55596722, 0.77062998),
        listOf(2.10646779, 0.52373058),
        listOf(0.47661083, -0.31979119),
        listOf(1.82472257, 0.01536231),
        listOf(2.09997092, -0.03778532),
        listOf(-0.94984084, 0.08042735),
        listOf(1.06157496, 0.27536549),
        listOf(-0.85076162, 0.53485641),
        listOf(-0.01544213, 0.02737309),
        listOf(0.38214003, 0.92617381),
        listOf(-0.00362931, 0.97178178),
        listOf(1.08907144, 0.38384707),
        listOf(0.64170651, 0.81655411),
        listOf(1.17803685, -0.42899752),
        listOf(0.69014074, 0.85799574),
        listOf(0.34409022, 1.10096579),
        listOf(0.4058595, 1.00739165),
        listOf(0.25724665, -0.3322832),
        listOf(0.96409772, 0.15551619),
        listOf(1.45898456, -0.40606902),
        listOf(-1.07486018, 0.28851566),
        listOf(1.87808614, 0.27675272),
        listOf(1.92477856, -0.18994089),
        listOf(1.71087646, -0.32558823),
        listOf(-0.30155436, 0.91804107),
        listOf(0.81728299, 0.41924128),
        listOf(0.19235396, 0.21902982),
        listOf(0.44754745, 0.97630087),
        listOf(-0.20377389, 0.92423194),
        listOf(0.12288573, 0.12093836),
        listOf(0.76529683, -0.62830856),
        listOf(1.00651233, 0.0085721),
        listOf(1.04024084, 0.08761088)
    )

    val y = listOf(
        1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, -1, 1, -1,
        -1, 1, -1, 1, 1, 1, 1, -1, 1, -1, 1, 1, 1, -1, -1, -1, 1,
        1, 1, -1, 1, 1, -1, -1, 1, -1, 1, -1, 1, -1, -1, -1, -1, 1,
        -1, 1, 1, 1, -1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, -1, -1,
        1, 1, 1, 1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1, -1, 1,
        -1, 1, -1, 1, 1, 1, -1, -1, 1, -1, -1, 1, 1, -1, -1
    )
}

fun loss(model: MLP, inputs: List<List<Value>>, y: List<Int>): Pair<Value, Double> {
    // forward the model to get scores
    val scores = inputs.map { model(it).single() }

    // svm "max-margin" loss

    val losses = y.zip(scores).map { (yi, scorei) -> (1.0 + -yi * scorei).relu() }

    val dataLoss = losses.sum() / losses.size

    // L2 regularization
    val alpha = 1e-4
    val regLoss = alpha * model.parameters.sumOf { it * it }
    val totalLoss = dataLoss + regLoss

    // also get accuracy
    val accuracy = y.zip(scores).map { (yi, scorei) -> (yi > 0) == (scorei.data > 0) }.map { if (it) 1.0 else 0.0 }

    return Pair(totalLoss, accuracy.sum() / accuracy.size)
}


fun main() {
    val x = MoonsDataSet.X
    val y = MoonsDataSet.y

    val inputs = x.map { row -> row.map { Value(it) } }

    val model = MLP(2, listOf(16, 16, 1)) // 2-layer neural network

    println(model)
    println("number of parameters: ${model.parameters.size}")

    repeat(100) { k ->
        // forward
        val (totalLoss, acc) = loss(model, inputs, y)

        // backward
        model.zeroGrad()
        totalLoss.backward()

        // update(sgd)
        val learningRate = 1.0 - 0.9 * k / 100
        for (p in model.parameters)
            p.data -= learningRate * p.grad

        println("step $k loss ${totalLoss.data}, accuracy ${acc * 100}%")
    }
}
