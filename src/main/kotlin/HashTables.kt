fun main() {
    checkVoter("James")
    checkVoter("Aiden")
    checkVoter("Aiden")
    addBookItems()
    println(book["avocado"])
}

val book = HashMap<String, Double>()

fun addBookItems() {
    book["apple"] = 0.67
    book["milk"] = 1.49
    book["avocado"] = 1.49
    println(book)
}

val voted = HashMap<String, Boolean>()

fun checkVoter(name: String) {
    when(voted.containsKey(name)) {
        true -> println("Kick them out!")
        else -> {
            println("Let them vote!")
            voted[name] = true
        }
    }
}

//val cache = HashMap<String, String>()
//
//fun getPage(url: String) = when (cache.containsKey(url)) {
//    true -> cache[url]
//    else -> {
//        val data = getDataFromServer(url)
//        cache[url] = data
//        data
//    }
//}

/**
 * Exercises
 *
 * 5.1: Consistent
 *
 * 5.2: Not consistent
 *
 * 5.3: Not consistent
 *
 * 5.4: Consistent
 *
 * 5.5: d / c
 *
 * 5.6: b / d
 *
 * 5.7: c / d / b
 */
