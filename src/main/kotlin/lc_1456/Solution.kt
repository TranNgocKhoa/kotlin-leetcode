package lc_1456

class Solution {
    fun maxVowels(s: String, k: Int): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')

        var i = 0
        var maxLength = 0
        var count = 0
        var j = 0

        while (i < k && i < s.length) {
            if (s[i] in vowels) {
                count++
            }
            i++
        }

        maxLength = count
        while (i < s.length) {
            if (s[i] in vowels) {
                count++
            }
            i++
            if (s[j] in vowels) {
                count--
            }
            j++

            if (count > maxLength) {
                maxLength = count
            }
        }

        return maxLength
    }
}

fun main() {
    println(Solution().maxVowels("abciiidef", 3))
    println(Solution().maxVowels("aeiou", 2))
    println(Solution().maxVowels("leetcode", 3))
    println(Solution().maxVowels("weallloveyou", 7))
}