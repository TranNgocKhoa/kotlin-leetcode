package lc_1679

class Solution_UseMap {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val freqMap = mutableMapOf<Int, Int>()
        var count = 0

        for (num in nums) {
            val complement = k - num
            if (freqMap.getOrDefault(complement, 0) > 0) {
                count++
                freqMap[complement] = freqMap[complement]!! - 1
            } else {
                freqMap[num] = freqMap.getOrDefault(num, 0) + 1
            }
        }

        return count
    }
}

fun main() {
    println(Solution_UseMap().maxOperations(intArrayOf(1, 2, 3, 4), 5))
    println(Solution_UseMap().maxOperations(intArrayOf(3, 1, 3, 4, 3), 6))
}