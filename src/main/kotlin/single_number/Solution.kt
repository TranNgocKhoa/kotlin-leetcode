package single_number

class Solution {

    /**
     * The hint tells us to use XOR.
     * XOR table:
     * 1 XOR 1: 0
     * 1 XOR 0: 1
     * 0 XOR 0: 0
     * => with duplicate numbers, their bits will appear 2 times, the result of XOR will be 0
     * The unique number has its bits appear 1 time, the result of XOR will be 1
     */
    fun singleNumber(nums: IntArray): Int {
        var unique = 0

        for (num in nums) {
            unique = unique.xor(num)
        }

        return unique
    }
}