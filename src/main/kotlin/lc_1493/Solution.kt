package lc_1493

import kotlin.math.max

class Solution {
    //[0,1,1,1,0,1,1,0,1] => 5

    fun longestSubarray(nums: IntArray): Int {
        var start = 0
        var end = 0
        var deleted = 0
        while (end < nums.size) {
            if (nums[end] == 0) {
                deleted++ // just borrow deleted first
            }

            // if > 1 mean you deleted before and now you need to deleted again.
            // This means you need to move you window ahead.
            if (deleted > 1) {
                // if nums[start] == 0, you can get back a "deleted"
                if (nums[start] == 0) {
                    deleted--
                }
                // move you window ahead.
                start++
            }

            end++
        }

        return end - start - 1
    }
}

fun main() {
    Solution().longestSubarray(intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)).let(::println) //5
    Solution().longestSubarray(intArrayOf(1, 1, 0, 1)).let(::println) //3
}