package lc_643

class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var sum = 0
        var index = 0
        repeat(k) {
            sum += nums[index++]
        }

        var maxSum: Int = sum

        var firstIndex = 1
        var lastIndex = k

        while (lastIndex < nums.size) {
            sum = sum - nums[firstIndex - 1] + nums[lastIndex]

            if (sum > maxSum) {
                maxSum = sum
            }
            firstIndex++
            lastIndex++

        }


        return maxSum.toDouble() / k
    }
}

fun main() {
    println(Solution().findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4))
}