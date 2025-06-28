package lc_151_reverse_words

class Solution {
    fun reverseWords(s: String): String {
        val result = StringBuilder()

        var i = s.length - 1
        while (i >= 0) {
            val word = StringBuilder()
            while (i >= 0 && s[i] != ' ') {
                word.append(s[i--])
            }
            result.append(word.reverse()).append(' ')

            while (i >= 0 && s[i] == ' ') {
                i--
            }
        }
        return result.toString().trim()
    }
}

fun main() {
    println("\"" + Solution().reverseWords("the sky is blue") + "\"")
    println("\"" + Solution().reverseWords("a good   example") + "\"")
    println("\"" + Solution().reverseWords("  hello world  ") + "\"")
}