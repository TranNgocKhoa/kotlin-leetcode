package lc_3202

import kotlin.math.max

class Solution {
    fun maximumLength(nums: IntArray, k: Int): Int {
        val f = Array(k) { IntArray(k) }
        var ans = 0
        for (x in nums) {
            var x = x
            x %= k
            for (j in 0..<k) {
                val y = (j - x + k) % k
                f[x][y] = f[y][x] + 1
                ans = max(ans, f[x][y])
            }
        }
        return ans
    }
}