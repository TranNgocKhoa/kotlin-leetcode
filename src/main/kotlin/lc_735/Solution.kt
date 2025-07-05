package lc_735

import java.util.*
import kotlin.math.abs

class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()

        for (asteroid in asteroids) {
            var collisionOccurred = false

            while (stack.isNotEmpty() && stack.peek() > 0 && asteroid < 0) {
                val topAsteroid = stack.peek()
                when {
                    abs(topAsteroid) == abs(asteroid) -> {
                        stack.pop()
                        collisionOccurred = true
                        break
                    }

                    abs(topAsteroid) < abs(asteroid) -> {
                        stack.pop()
                    }

                    else -> {
                        collisionOccurred = true
                        break
                    }
                }
            }

            if (!collisionOccurred) {
                stack.push(asteroid)
            }
        }

        return stack.toIntArray()
    }
}

fun main() {
    val solution = Solution()
//    solution.asteroidCollision(intArrayOf(5, 10, -5)).forEach { println(it) } // 5 10
//    solution.asteroidCollision(intArrayOf(10, 2, -5)).forEach { println(it) } // 10
//    solution.asteroidCollision(intArrayOf(-2, -1, 1, 2)).forEach { println(it) } //-2 -1 1 2 // move away, no collision
//    solution.asteroidCollision(intArrayOf(8, -8)).forEach { println(it) } // empty
    solution.asteroidCollision(intArrayOf(-2,-2,2,1)).forEach { println(it) } // empty
}