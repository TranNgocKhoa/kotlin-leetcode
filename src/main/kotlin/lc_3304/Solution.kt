package lc_3304

class Solution {
    fun kthCharacter(k: Int): Char {
        var init = "a"
        while (init.length < k) {
            val next = StringBuilder()
            for (j in 0..init.length - 1) {
                val currentChar = init[j]
                next.append(currentChar + 1)
            }

            init += next.toString()
        }

        return init[k - 1]
    }
}