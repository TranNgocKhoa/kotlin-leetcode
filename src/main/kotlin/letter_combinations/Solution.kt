package letter_combinations

class Solution {
    private val mapDigit = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations_backtrack(digits: String): List<String> {
        val result = mutableListOf<String>()
        if (digits.isEmpty()) {
            return result
        }
        backtrack(0, StringBuilder(), digits, result)

        return result
    }

    private fun backtrack(index: Int, currentCombination: StringBuilder, digits: String, result: MutableList<String>) {
        if (index == digits.length) {
            result.add(currentCombination.toString())
            return
        }

        val digitChar = digits[index]
        val digitMap = mapDigit[digitChar]!!

        for (ch in digitMap) {
            currentCombination.append(ch)

            backtrack(index + 1, currentCombination, digits, result)

            currentCombination.deleteCharAt(currentCombination.length - 1)
        }
    }


    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        var result: ArrayList<String> = mapDigit[digits[0]]!!.map { ch -> ch.toString() } as ArrayList<String>
        var index = 1

        while (index < digits.length) {
            result = combineWith(result, mapDigit[digits[index]]!!.map { ch -> ch.toString() } as ArrayList<String>)
            index++
        }

        return result
    }

    fun combineWith(first: List<String>, second: List<String>): ArrayList<String> {
        val result = ArrayList<String>()

        for (f in first) {
            for (s in second) {
                result.add("$f$s")
            }
        }

        return result

    }
}

fun main() {
    Solution().letterCombinations_backtrack("23").forEach { print("$it ") }
    println()
    Solution().letterCombinations("23").forEach { print("$it ") }
}