package lc_392

class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var sIndex = 0
        var tIndex = 0

        while (tIndex < t.length && sIndex < s.length) {
            if (s[sIndex] == t[tIndex]) {
                sIndex++
            }
            tIndex++
        }

        return sIndex == s.length
    }
}

fun main() {
    println(Solution().isSubsequence("abc", "ahbgdc"))
}