package find_first_and_last_pos_sorted_array

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {

        return intArrayOf(findFirst(nums, target), findLast(nums, target))
    }


    fun findFirst(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        var result = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                result = mid
                right = mid - 1
            } else if (nums[mid] > target) {
                right = mid - 1
            } else if (nums[mid] < target) {
                left = mid + 1
            }
        }

        return result
    }

    fun findLast(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        var result = -1
        while (left <= right) {
            val mid = left + (right - left) / 2

            if (nums[mid] == target) {
                result = mid
                left = mid + 1
            } else if (nums[mid] > target) {
                right = mid - 1
            } else if (nums[mid] < target) {
                left = mid + 1
            }
        }

        return result
    }
}

fun main() {
    Solution().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).forEach { println("$it ") }
}