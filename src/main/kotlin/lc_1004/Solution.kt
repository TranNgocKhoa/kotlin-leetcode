package lc_1004

class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {

        var start = 0 // start of the window
        var end = 0 // end of the window
        var flipCount = k // count of possible flips

        while (end < nums.size) {
            if (nums[end] == 0) { // faced with zero. spending 1 flip
                flipCount--
            }

            if (flipCount < 0) { // flips are finished, we have to move the end of range
                if (nums[start] == 0) { // if released symbol is zero, we returned one flip
                    flipCount++
                }
                start++ // move start of the window ahead
            }

            end++ // move the end of the window ahead
        }
        return end - start // difference between start and end - our maximum range
    }
}

fun main() {
    Solution().longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2).let(::println)
    Solution().longestOnes(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3).let(::println)
}