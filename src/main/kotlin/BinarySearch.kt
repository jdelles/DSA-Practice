fun main() {
    val binarySearch = BinarySearch()
    val myList = listOf(1, 3, 5, 7, 9)
    println(binarySearch.findValue(3, myList))
    println(binarySearch.findValue(-1, myList))
}

class BinarySearch {
    fun findValue(target: Int, list: List<Int>): Int? {
        var low = 0
        var high = list.size - 1
        while (low <= high) {
            val mid = (low + high) / 2
            val guess = list[mid]
            if (guess == target) return mid
            else if (guess > target) high = mid - 1
            else low = mid + 1
        }
        return null
    }
}

/**
 * Exercises
 *
 * 1.1: Max # of steps to search a list of 128 names
 * log base 2 of 128 = 7
 *
 * 1.2: Double the size of the list. How many steps now?
 * log base 2 of 256 = 8
 *
 * 1.3: Search for name in phone book
 * O(log n)
 *
 * 1.4: Search for number in phone book
 * O(n)
 *
 * 1.5: Read number of every person in phone book
 * O(n)
 *
 * 1.6: Read the number of just the As
 * O(n)
 */