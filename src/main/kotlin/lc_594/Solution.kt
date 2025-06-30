package lc_594

import kotlin.math.max

class Solution {
    fun findLHS(nums: IntArray): Int {
        nums.sort()

        var maxLength = 0
        var startOfSequence = 0
        for (i in 0 until nums.size) {
            // Increase startOfSequence
            // if the difference between the current number and the start of the sequence is greater than 1
            while (nums[i] - nums[startOfSequence] > 1) {
                startOfSequence++
            }

            // If the difference is exactly 1, we can calculate the length of the harmonious subsequence
            if (nums[i] - nums[startOfSequence] == 1) {
                maxLength = max(maxLength, i - startOfSequence + 1);
            }

            // If the difference is 0, we continue to the next number
        }

        return maxLength
    }
}

fun main() {

}