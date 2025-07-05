package lc_394

import java.util.*


class Solution {
    fun decodeString(s: String): String {
        val numberStack = Stack<Int>()
        val stringStack: Stack<String> = Stack()
        var num = 0
        var decodedString = ""
        for (c in s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                num = num * 10 + c.code - '0'.code
            } else if (c == '[') {
                numberStack.push(num)
                stringStack.push(decodedString)
                num = 0
                decodedString = ""
            } else if (c == ']') {
                val repeatString = StringBuilder()
                var i = 0
                val n: Int = numberStack.pop()
                while (i < n) {
                    repeatString.append(decodedString)
                    ++i
                }
                decodedString = stringStack.pop() + repeatString.toString()
            } else {
                decodedString += c.toString()
            }
        }

        return decodedString
    }
}


fun main() {
    val solution = Solution()

    solution.decodeString("3[a]2[bc]").let { println(it) }
}