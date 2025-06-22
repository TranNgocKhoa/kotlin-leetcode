package divide_two_integers

import kotlin.math.abs

class Solution {

    fun divide(dividend: Int, divisor: Int): Int {
        if (dividend == Int.MIN_VALUE && divisor == -1) {
            return Int.MAX_VALUE
        }

        val isNegative = (dividend xor divisor) < 0

        var absDividend = abs(dividend.toLong())
        val absDivisor = abs(divisor.toLong())

        var quotient = 0

        // same loop as naive
        while (absDividend >= absDivisor) {
            var tempDivisor = absDivisor
            var multiple = 1

            // Game changer: Use bit shift for minus faster
            while ((tempDivisor shl 1) <= absDividend && (tempDivisor shl 1) > 0) {
                tempDivisor = tempDivisor shl 1
                multiple = multiple shl 1
            }

            // If cannot shift bit, then the loop above bypassed and move to minus steps
            absDividend -= tempDivisor
            quotient += multiple
        }

        return if (isNegative) -quotient else quotient
    }


    fun divide_naive(dividend: Int, divisor: Int): Int {
        if (dividend == Int.MIN_VALUE && divisor == -1) {
            return Int.MAX_VALUE;
        }

        if (dividend == divisor) {
            return 1
        }

        var count = 0
        val isNegative = (dividend < 0).xor(divisor < 0)
        var absDividend = abs(dividend)
        val absDivisor = abs(divisor)

        if (absDivisor == 1) {
            return (if (isNegative) -1 else 1) * absDividend
        }

        while (absDivisor - absDividend <= 0) {
            absDividend -= absDivisor;
            count++
        }
        return (if (isNegative) -1 else 1) * count
    }
}

fun main() {
    val solution = Solution()
//    println(solution.divide(2, 2))
//    println(solution.divide(10, 3))
//    println(solution.divide(7, -3))
//    println(solution.divide(-1, -1))
//    println(solution.divide(-1, 1))
    println(solution.divide(-2147483648, 2))
}