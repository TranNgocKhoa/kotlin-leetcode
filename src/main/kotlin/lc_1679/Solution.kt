package lc_1679

class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        nums.sort()

        var left = 0
        var right = nums.size - 1

        var count = 0
        while (left < right) {
            val sum = nums[left] + nums[right]

            if (sum < k) {
                left++
            } else if (sum > k) {
                right--
            } else {
                count++
                left++
                right--
            }
        }

        return count
    }
}

fun main() {
    println(Solution().maxOperations(intArrayOf(1, 2, 3, 4), 5))
    println(Solution().maxOperations(intArrayOf(3, 1, 3, 4, 3), 6))
}