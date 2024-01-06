fun main() {
    val testList = listOf(1, 2, 3, 4)
    println("SUM   Expected: 10, Actual: ${sum(testList)}")
    println("COUNT Expected:  4, Actual:  ${count(testList)}")
    println("MAX   Expected:  4, Actual:  ${max(testList)}")
    println("MAX   Expected:  4, Actual:  ${max(testList.reversed())}")
    println("BS    Expected:  2, Actual:  ${binarySearch(testList, 3)}")
    println("BS    Expected: -1, Actual: ${binarySearch(testList, 8)}")

    val quickSortList = listOf(5, 4, 1, 3, 2)
    println("QS    Expected: [1, 2, 3, 4, 5] Actual: ${quickSort(quickSortList)}")
}

// 4.1

fun sum(arr: List<Int>): Int = when (arr.size) {
    0 -> 0
    else -> arr[0] + sum(arr.drop(1))
}

// 4.2

fun count(arr: List<Int>): Int = when (arr.size) {
    0 -> 0
    else -> 1 + count(arr.drop(1))
}

// 4.3

fun max(arr: List<Int>): Int = when (arr.size) {
    1 -> arr[0]
    else -> {
        if (arr.first() > arr.last()) {
            max(arr.dropLast(1))
        } else {
            max(arr.drop(1))
        }
    }
}

// 4.4

fun binarySearch(arr: List<Int>, target: Int): Int = when (arr.size) {
    0 -> -1
    else -> {
        val mid = arr.size / 2
        if (arr[mid] == target) mid
        else if (arr[mid] > target) binarySearch(arr.dropLast(arr.size - mid), target)
        else binarySearch(arr.drop(arr.size - mid), target)
    }
}

// 4.5

fun quickSort(arr: List<Int>): List<Int> = when (arr.size) {
    0, 1 ->  arr
    else -> {
        val pivot = arr[0]
        val less = arr.filter { it < pivot }
        val greater = arr.filter { it > pivot}
        quickSort(less) + pivot + quickSort(greater)
    }
}

/**
 * Exercises
 *
 * 4.6: O(n)
 *
 * 4.7: O(n)
 *
 * 4.8 O(1)
 *
 * 4.9 O(n^2) <--- could definitely be solved in O(n) with memoization
 */
