package Chapter7

fun main() {
    val processed = mutableListOf<String>()

    val graph = mapOf(
        "start" to mapOf("a" to 6.0, "b" to 2.0),
        "a" to mapOf("fin" to 1.0),
        "b" to mapOf("a" to 3.0, "fin" to 5.0),
        "fin" to HashMap(),
    )

    val costs = mutableMapOf(
        "a" to 6.0,
        "b" to 2.0,
        "fin" to Double.MAX_VALUE,
    )

    val parents = mutableMapOf(
        "a" to "start",
        "b" to "start",
        "fin" to null,
    )

    var node = findLowestCostNode(costs, processed)
    while (node != null) {
        val cost = costs[node]!!
        val neighbors = graph[node]!!

        for (n in neighbors.keys) {
            val newCost = cost.plus(neighbors[n]!!)
            if (costs[n]!! > newCost) {
                costs[n] = newCost
                parents[n] = node
            }
        }

        processed.add(node)
        node = findLowestCostNode(costs, processed)
    }
    println("Cost from the start to each node: ")
    println(costs) // Expected: 5, 2, 6
}

fun findLowestCostNode(
    costs: Map<String, Double>,
    processed: List<String>,
): String? {
    var lowestCost = Double.MAX_VALUE
    var lowestCostNode: String? = null

    for (node in costs) {
        val cost = node.value
        if (cost < lowestCost && !processed.contains(node.key)) {
            lowestCost = cost
            lowestCostNode = node.key
        }
    }

    return lowestCostNode
}
