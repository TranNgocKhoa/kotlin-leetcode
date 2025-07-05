package lc_2390

import java.util.*

class Solution {
    fun removeStars(s: String): String {
        val stack = Stack<Char>()

        s.forEach {
            when (it) {
                '*' -> stack.pop()
                else -> stack.push(it)
            }
        }

        return stack.joinToString("")
    }
}