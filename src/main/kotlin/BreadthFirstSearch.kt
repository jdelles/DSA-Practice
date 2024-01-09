import java.util.ArrayDeque

fun main() {
    breadthFirstSearch("you")
}

val graph = hashMapOf(
    "you" to listOf("alice", "bob", "claire"),
    "bob" to listOf("anuj", "peggy"),
    "alice" to listOf("peggy"),
    "claire" to listOf("thom", "jennys"),
    "anuj" to emptyList(),
    "peggy" to emptyList(),
    "thom" to emptyList(),
    "jonny" to emptyList()
)

fun breadthFirstSearch(name: String) {
    val queue = ArrayDeque(graph[name])
    val searched = mutableSetOf<String>()
    while (queue.isNotEmpty()) {
        val person = queue.poll()
        if (!searched.contains(person)) {
            if (person.isSeller()) {
                println("$person is seller")
                return
            } else {
                graph[person]?.let { queue.addAll(it) }
                searched.add(person)
            }
        }
    }
    println("No seller found")
}

fun String.isSeller(): Boolean = this.endsWith("s")

/**
 * Exercises
 *
 * 6.1: 2
 *
 * 6.2: 2
 *
 * 6.3: a - no, b = yes, c - no
 *
 * 6.4: wake up, exercise, shower, get dressed, brush teeth, eat breakfast, pack lunch
 *
 * 6.5: a, c
 *
 *
 */