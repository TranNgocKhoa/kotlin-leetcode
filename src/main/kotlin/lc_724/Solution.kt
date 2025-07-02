package lc_724

class Solution {
    fun pivotIndex(nums: IntArray): Int {
        if (nums.isEmpty()) return -1
        if (nums.size == 1) return 0
        val prefixSum = IntArray(nums.size)
        val postfixSum = IntArray(nums.size)

        for (i in nums.indices) {
            if (i == 0) {
                prefixSum[i] = nums[i]
                postfixSum[nums.size - i - 1] = nums[nums.size - i - 1]
            } else {
                prefixSum[i] = nums[i] + prefixSum[i - 1]
                postfixSum[nums.size - i - 1] = nums[nums.size - i - 1] + postfixSum[nums.size - i]
            }
        }

        for (i in 0 until nums.size) {
            if (i == 0) {
                if (0 == postfixSum[i + 1]) {
                    return 0
                }
                continue
            }

            if (i == nums.size - 1) {
                if (0 == prefixSum[i - 1]) {
                    return i
                }
                continue
            }
            if (prefixSum[i - 1] == postfixSum[i + 1]) {
                return i
            }
        }

        return -1
    }
}

fun main() {
//    println(Solution().pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)))
    println(Solution().pivotIndex(intArrayOf(2, 1, -1)))
}