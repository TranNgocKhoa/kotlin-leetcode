package lc_3136

class Solution {
    fun isValid(word: String): Boolean {
        if (word.length < 3) {
            return false
        }

        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val digits = setOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0')
        var vowelCount = 0
        var consonantCount = 0
        for (ch in word) {
            if (ch < '0' || (ch > '9' && ch < 'A') || (ch > 'Z' && ch < 'a') || ch > 'z') return false

            if (ch in vowels) {
                vowelCount++
            } else if (consonantCount < 1 && ch !in digits) {
                consonantCount++
            }
        }

        return vowelCount > 0 && consonantCount > 0
    }
}

fun main() {
    Solution().isValid("UuE6").let(::println)
}