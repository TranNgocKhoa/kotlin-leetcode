package longest_palindromic_substring

import kotlin.math.max

class Solution {
    fun longestPalindrome(s: String): String {
        var start = 0
        var end = 0
        var maxLen = 0
        for (i: Int in 0 until s.length - 1) {
            val lenOdd = expandAround(s, i, i)
            val lenEven = expandAround(s, i, i + 1)

            val len = max(lenEven, lenOdd)

            if (len > maxLen) {
                maxLen = len
                if (lenOdd > lenEven) {
                    // 0 1 2 3 4 5 6
                    // a b a a b a a
                    start = i - (len - 1) / 2
                    end = i + (len - 1) / 2
                }
                if (lenEven > lenOdd) {
                    // 0 1 2 3 4 5 6 7
                    // a b a a b b a a => len = 6
                    start = i - (len - 1) / 2
                    end = i + 1 + (len - 1) / 2
                }
            }
        }

        return s.substring(start, end + 1)
    }


    private fun expandAround(s: String, left: Int, right: Int): Int {
        var left = left
        var right = right
        while (left > 0 && right < s.length - 1 && s[left] == s[right]) {
            if (s[left - 1] == s[right + 1]) {
                left--
                right++
            } else {
                break
            }
        }

        // a b a

        return right - left + 1
    }
}

fun main() {
    val solution = Solution()
    println(solution.longestPalindrome("ssssass"))
    println(solution.longestPalindrome("babad"))

}