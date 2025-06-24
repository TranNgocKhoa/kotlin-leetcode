package merge_strings_alternatively

class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val result = StringBuilder()

        var index = 0
        while (index < word1.length && index < word2.length) {
            result.append(word1[index]).append(word2[index])
            index++
        }

        if (index <= word1.length - 1) {
            return result.append(word1.substring(index, word1.length)).toString()
        }

        if (index <= word2.length - 1) {
            return result.append(word2.substring(index, word2.length)).toString()
        }

        return result.toString()
    }
}

fun main() {
//    println(Solution().mergeAlternately("abc", "phr"))
    println(Solution().mergeAlternately("cf", "eee"))
}