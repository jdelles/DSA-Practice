package Chapter7

fun main() {
    val graph = mapOf(
        "start" to mapOf("a" to 6.0, "b" to 2.0),
        "a" to mapOf("fin" to 1.0),
        "b" to mapOf("a" to 3.0, "fin" to 5.0),
        "fin" to HashMap(),
    )

    println(dijkstra(graph, "start"))

}

fun dijkstra(graph: Map<String, Map<String, Double>>, startingNode: String): Map<String, Double> {
    val shortestDistances = mutableMapOf<String, Double>()
    val processed = mutableListOf<String>()
    val parents = mutableMapOf<String, String>()

    graph.keys.forEach { node ->
        shortestDistances[node] = if (node == startingNode) 0.0 else Double.MAX_VALUE
    }

    while (true) {
        val currentNode = shortestDistances
            .filter { !processed.contains(it.key) }
            .minByOrNull { it.value }?.key
            ?: break

        processed.add(currentNode)

        graph[currentNode]?.forEach { (neighbor, distance) ->
            val newDistance = shortestDistances[currentNode]!! + distance
            if (newDistance < shortestDistances[neighbor]!!) {
                shortestDistances[neighbor] = newDistance
                parents[neighbor] = currentNode
            }
        }
    }

    val shortestPaths = shortestDistances.keys.associateWith { node ->
        generateSequence(node) { parents[it] }.toList().asReversed()
    }

    println(shortestPaths)

    return shortestDistances
}
