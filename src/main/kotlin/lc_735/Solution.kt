package lc_735

import java.util.*
import kotlin.math.abs

class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()

        for (asteroid in asteroids) {
            stack.push(asteroid)

            while (stack.isNotEmpty() && stack.size > 1) {
                val asteroid = stack.pop()
                val peek = stack.peek()
                if (peek * asteroid > 0 || (peek < 0 && asteroid > 0)) {
                    stack.push(asteroid)
                    break
                } else {
                    if (abs(peek) == abs(asteroid)) {
                        stack.pop()
                    } else if (abs(peek) <= abs(asteroid)) {
                        stack.pop()
                        stack.push(asteroid)
                    }
                }
            }
        }

        return stack.toIntArray()
    }
}

fun main() {
    val solution = Solution()
    solution.asteroidCollision(intArrayOf(5, 10, -5)).forEach { println(it) } // 5 10

    solution.asteroidCollision(intArrayOf(10, 2, -5)).forEach { println(it) } // 10

    solution.asteroidCollision(intArrayOf(-2, -1, 1, 2)).forEach { println(it) } //-2 -1 1 2 // move away, no collision

    solution.asteroidCollision(intArrayOf(8, -8)).forEach { println(it) } // empty
}