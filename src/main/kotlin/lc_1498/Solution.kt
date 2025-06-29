package lc_1498

class Solution {
    val mod = 1_000_000_007
    fun numSubseq(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return 0

        val powOf2 = IntArray(nums.size) { 1 }
        for (i in 1 until nums.size) {
            powOf2[i] = powOf2[i - 1] * 2 % mod
        }

        nums.sort()
        var result = 0
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // left is fixed as a minimum.
                // the maximum can be any number between left and right.
                // => subsequences = 2 ^ (right - left). Because we just add num[left] in each subsequence, we exclude left.
                result = (result + powOf2[right - left]) % mod
                // now increase left.
                left++
            } else {
                right--
            }
        }

        return result
    }


}


fun main() {
    println(Solution().numSubseq(intArrayOf(3, 3, 6, 8), 10))
    println(Solution().numSubseq(intArrayOf(2, 3, 3, 4, 6, 7), 12))


    println(Solution().numSubseq(intArrayOf(3, 5, 6, 7), 9))
}