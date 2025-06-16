package find_k_closest_elements

import java.util.*
import kotlin.math.abs

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var findIndex = Arrays.binarySearch(arr, x)
        if (findIndex < 0) {
            findIndex = -(findIndex + 1)
        }

        var left = findIndex - 1
        var right = findIndex

        while (right - left - 1 < k) {
            if (left < 0) {
                right++
            } else if (right > arr.size - 1) {
                left--
            } else if (abs(arr[left] - x) <= abs(arr[right] - x)) {
                left--
            } else {
                right++
            }
        }

        left = left + 1
        right = right - 1

        return arr.slice(left..right)
    }
}

fun main() {
    Solution().findClosestElements(intArrayOf(1, 2, 3, 4, 5), 4, 3).forEach { print("$it ") }
    println()
    Solution().findClosestElements(intArrayOf(1, 1, 2, 3, 4, 5), 4, -1).forEach { print("$it ") }
    println()
    Solution().findClosestElements(intArrayOf(1, 1, 1, 10, 10, 10), 1, 9).forEach { print("$it ") }
    println()
    Solution().findClosestElements(intArrayOf(0, 0, 1, 2, 3, 3, 4, 7, 7, 8), 3, 5).forEach { print("$it ") }
}