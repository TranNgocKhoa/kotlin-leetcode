package string_to_integer

class Solution {
    fun myAtoi(str: String): Int {
        if (str.isEmpty()) {
            return 0
        }

        var i = 0

        while (i < str.length) {
            if (str[i] == ' ') {
                i++
            } else if (str[i].isDigit()) {
                break
            } else if (str[i] == '-' || str[i] == '+') {
                break
            } else {
                return 0
            }
        }

        if (i >= str.length) {
            return 0
        }

        var sign = 1
        if (str[i] == '-') {
            sign = -1
            i++
        } else if (str[i] == '+') {
            i++
        }

        var result = 0
        for (c in str.drop(i)) {
            if (c.isDigit()) {
                val digit: Int = c - '0'
                if (sign == 1) {
                    if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                        return Integer.MAX_VALUE
                    }

                    result = result * 10 + digit
                } else {
                    if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit > 8)) {
                        return Integer.MIN_VALUE
                    }

                    result = result * 10 - digit
                }
            } else {
                break
            }
        }

        return result
    }
}

fun main() {
    val solution = Solution()

    println(solution.myAtoi("   -042"))
    println(solution.myAtoi(" "))
}