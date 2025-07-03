package lc_1657

class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false

        val occurrence1 = HashMap<Char, Int>()
        val occurrence2 = HashMap<Char, Int>()

        for (i in 0 until word1.length) {
            val char1 = word1[i]
            val char2 = word2[i]
            occurrence1[char1] = occurrence1.getOrDefault(char1, 0) + 1
            occurrence2[char2] = occurrence2.getOrDefault(char2, 0) + 1
        }

        return occurrence1.size == occurrence2.size
                && occurrence1.keys.sorted() == occurrence2.keys.sorted()
                && occurrence1.values.sorted() == occurrence2.values.sorted()
    }
}

fun main() {
    println(Solution().closeStrings("abbzzca", "babzzcz"))
}