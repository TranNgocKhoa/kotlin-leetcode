package three_sum


internal class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>(nums.size * nums.size / 6)

        nums.sort()

        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            var left = i + 1
            var right = nums.lastIndex

            while (left < right) {
                val sum = nums[left] + nums[right]
                if (sum + nums[i] == 0) {
                    result.add(listOf(nums[i], nums[left], nums[right]))

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--
                    }

                    left++
                    right--
                } else if (sum + nums[i] > 0) {
                    right--
                } else {
                    left++
                }
            }
        }

        return result
    }

    private fun needToZero(inputVal: Int): Int {
        return -inputVal
    }
}

fun main() {
    Solution().threeSum(
        intArrayOf(-1, 0, 1, 2, -1, -4)
    ).forEach { ints -> println(ints.joinToString(",")) }
}