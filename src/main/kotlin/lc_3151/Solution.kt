package lc_3151

class Solution {
    fun isArraySpecial(nums: IntArray): Boolean {
        if (nums.size < 2) return true
        for (i in 0 until  nums.size) {
            if ((nums[i] + nums[i + 1]) % 2 == 0) {
                return false
            }
        }

        return true
    }
}

fun main() {
    println(Solution().isArraySpecial(intArrayOf(4, 3, 1, 6)))
    println(Solution().isArraySpecial(intArrayOf(1)))
    println(Solution().isArraySpecial(intArrayOf(2,1,4)))
}