package lc_3307

class Solution {
    fun kthCharacter(k: Long, operations: IntArray): Char {
        var k = k
        var n = 1L
        var i = 0
        while (n < k) {
            n *= 2
            i++
        }
        var d = 0
        while (n > 1) {
            if (k > n / 2) {
                k -= n / 2
                d += operations[i - 1]
            }
            n /= 2
            i--
        }
        return ('a' + (d % 26))
    }
}