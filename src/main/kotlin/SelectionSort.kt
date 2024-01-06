fun main() {
    val array = arrayListOf(0, 2, 5, 1, 8, 23, 31, 21, 93, 213, 31, 11, 1512, 231, 341, 516, 132, 322, 421, 643)
    print("sort: ${array.selectionSort()}")
}

fun ArrayList<Int>.getSmallest(): Int {
    var smallest = this[0]
    var index = 0
    for (i in 1..< size) {
        if (this[i] < smallest) {
            smallest = this[i]
            index = i
        }
    }
    return index
}

fun ArrayList<Int>.selectionSort(): ArrayList<Int> {
    val sortedArray = arrayListOf<Int>()
    for (i in 0 ..< size) {
        val smallest = getSmallest()
        sortedArray += this[smallest]
        removeAt(smallest)
    }
    return sortedArray
}

/**
 * Exercises
 *
 * 2.1: LinkedList because a list of expenses takes a lot of insertion.
 *
 * 2.2: LinkedList is better for queues especially if you have a pointer to the end item.
 *
 * 2.3: Array is better for random access and searching.
 *
 * 2.4: Inserts become O(n). Every time you add a new user, you need to sort the list.
 *
 * 2.5: The new structure would potentially be faster for inserting, slower for searching.
 */