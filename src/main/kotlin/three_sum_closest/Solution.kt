package three_sum_closest

import kotlin.math.abs

internal class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()

        var minDistance = Int.MAX_VALUE
        var closestSum = 0
        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            var left = i + 1
            var right = nums.lastIndex

            while (left < right) {
                val sum = nums[left] + nums[right]
                val threeSum = sum + nums[i]
                if (threeSum == target) {
                    return target
                } else {
                    val currentDistance = abs(threeSum - target)
                    if (currentDistance < minDistance) {
                        minDistance = currentDistance
                        closestSum = threeSum
                    }

                    if (threeSum > target) {
                        right--
                    } else {
                        left++
                    }
                }
            }
        }

        return closestSum
    }

    private fun needToZero(inputVal: Int): Int {
        return -inputVal
    }
}

fun main() {
    println(
        Solution().threeSumClosest(
            intArrayOf(-1, 2, 1, -4), 1
        )
    )
}