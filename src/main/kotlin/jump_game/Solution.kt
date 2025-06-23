package jump_game

class Solution {


    fun canJump(nums: IntArray): Boolean {
        var i = nums.size - 2

        while (i >= 0) {
            if (nums[i] == 0) {
                var j = i - 1
                while (j >= 0) {
                    if (nums[j] >= (i + 1) - j) {
                        break
                    } else {
                        j--
                    }
                }

                if (j < 0) {
                    return false
                }
            }
            i--
        }

        return true
    }



    fun canJump_v1(nums: IntArray): Boolean {
        var canJumps = true
        var i = nums.size - 2

        while (i >= 0) {
            if (nums[i] != 0) {
                canJumps = true
            } else {
                canJumps = false
                var j = i - 1
                while (j >= 0) {
                    if (canJump(nums, j, i + 1)) {
                        canJumps = true
                        break
                    } else {
                        j--
                    }
                }

                if (!canJumps) {
                    return false
                }
            }
            i--
        }

        return true
    }

    fun canJump(nums: IntArray, from: Int, to: Int): Boolean {
        return nums[from] >= to - from
    }
}

fun main() {
//    println(Solution().canJump(intArrayOf(2, 3, 1, 1, 4)))
//    println(Solution().canJump(intArrayOf(3, 2, 1, 0, 4)))
    println(Solution().canJump(intArrayOf(2, 0, 0)))
}