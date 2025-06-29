package lc_283

class Solution {

    fun moveZeroes(nums: IntArray) {
        if (nums.size < 2) {
            return
        }

        // Just move all non zero elements to a size.
        // Remaining element change to zero.

        var lastNonZeroIndex = 0
        for (i in 0 until nums.size) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex] = nums[i]
                lastNonZeroIndex++
            }
        }

        var remainingIndex = lastNonZeroIndex
        while (remainingIndex < nums.size) {
            nums[remainingIndex] = 0
            remainingIndex++
        }
    }

    fun moveZeroes_naive(nums: IntArray) {
        var index = 0

        while (index < nums.size - 1) {
            var nextNoneZero = -1
            if (nums[index] == 0) {
                nextNoneZero = index + 1
                while (nextNoneZero < nums.size - 1 && nums[nextNoneZero] == 0) {
                    nextNoneZero++
                }
                val temp = nums[index]
                nums[index] = nums[nextNoneZero]
                nums[nextNoneZero] = temp

                if (nextNoneZero >= nums.size - 1) {
                    break
                }
            }

            index++

        }
    }
}

fun main() {
//    val array1 = intArrayOf(0, 1, 0, 3, 12)
//    Solution().moveZeroes(array1)
//    array1.forEach { print("$it ") }
//
//    println()
//
//    val array2 = intArrayOf(0)
//    Solution().moveZeroes(array2)
//    array2.forEach { print("$it ") }
//
//    println()

    val array3 = intArrayOf(4, 2, 4, 0, 0, 3, 0, 5, 1, 0)
    Solution().moveZeroes(array3)
    array3.forEach { print("$it ") }
}