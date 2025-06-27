package reverse_vowels_of_string

class Solution {
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

    fun reverseVowels(s: String): String {
        var head = 0
        var tail = s.length - 1
        val result = s.toCharArray()

        while (head < tail) {
            if (!vowels.contains(s[head])) {
                head++
            } else {
                while (head < tail && !vowels.contains(s[tail])) {
                    tail--
                }

                if (head < tail) {
                    result[tail] = s[head]
                    result[head] = s[tail]
                    tail--
                    head++
                }
            }
        }

        return result.joinToString(separator = "")
    }
}

fun main() {
    println(Solution().reverseVowels("IceCreAm"))
}