package lc_238

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }
        var left = 1
        var right = 1
        for (i in 0 until nums.size) {
            result[i] *= left
            result[nums.size - 1 - i] *= right

            right *= nums[nums.size - 1 - i]
            left *= nums[i]
        }

        return result
    }


    fun productExceptSelf_v1(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }
        val leftProducts = IntArray(nums.size) { 1 }
        val rightProducts = IntArray(nums.size) { 1 }
        for (i in 0 until nums.size) {
            calculateLeftProduct(leftProducts, nums, i)
            calculateRightProduct(rightProducts, nums, nums.size - 1 - i)
        }

        for (i in 0 until nums.size) {
            result[i] = leftProducts[i] * rightProducts[i]
        }

        return result
    }

    fun calculateLeftProduct(result: IntArray, nums: IntArray, indexInclude: Int) {
        if (indexInclude > 0) {
            result[indexInclude] = result[indexInclude - 1] * nums[indexInclude - 1]
        }
    }

    fun calculateRightProduct(result: IntArray, nums: IntArray, indexInclude: Int) {
        if (indexInclude < nums.size - 1) {
            result[nums.size - indexInclude - 1] =
                result[nums.size - indexInclude - 1] * nums[nums.size - indexInclude - 1]
        }
    }

}

fun main() {
    val solution = Solution()
    solution.productExceptSelf(intArrayOf(1, 2, 3, 4))
        .forEach { println(it) }
}