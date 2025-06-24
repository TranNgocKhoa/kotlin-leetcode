package greatest_common_divisor_of_strings

import kotlin.math.min

class Solution {

    fun gcdOfStrings(str1: String, str2: String): String {
        // Step 1: Check for compatibility
        // If a common divisor string 'x' exists, then str1 must be x...x (k1 times)
        // and str2 must be x...x (k2 times).
        // In this case, str1 + str2 will be x...x (k1 + k2 times)
        // and str2 + str1 will also be x...x (k2 + k1 times).
        // Thus, str1 + str2 must be equal to str2 + str1.
        // If they are not equal, no common divisor string exists.
        if (str1 + str2 != str2 + str1) {
            return ""
        }

        // The length of the greatest common divisor string will be the
        // greatest common divisor of their lengths.
        val len1 = str1.length
        val len2 = str2.length

        val gcdLength = gcd(len1, len2)

        return str1.substring(0, gcdLength)
    }

    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) {
            return a
        }
        return gcd(b, a % b)
    }


    fun gcdOfStrings_naive(str1: String, str2: String): String {
        val minLength = min(str1.length, str2.length)
        var index = minLength
        var divider = 2
        while (index >= 1) {
            val substring1 = str1.substring(0, index)
            val substring2 = str2.substring(0, index)
            if (substring1.repeat(str1.length / index) == str1
                && substring2.repeat(str2.length / index) == str2
                && substring1 == substring2
            ) {
                return substring1
            }

            index = minLength / divider++
        }

        return ""
    }

}

fun main() {
    println(
        Solution().gcdOfStrings(
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",

            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
        )
    )

    println(
        Solution().gcdOfStrings(
            "ABC",

            "ABCABC"
        )
    )

    println(
        Solution().gcdOfStrings(
            "LEET",

            "CODE"
        )
    )
}