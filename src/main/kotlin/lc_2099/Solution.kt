package lc_2099

import java.util.*

class Solution {
    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        /**
         * Greedy: Subset with max sum -> sum of max items
         */
        return nums.indices.sortedBy { i -> -nums[i] } // sort in desc with value to compare is -1*nums[i]
            .subList(0, k) // get first k items
            .sortedBy { i -> i } // sort in original order
            .map { i -> nums[i] } // get nums[i]
            .toIntArray()
    }

    fun maxSubsequenceFaster(nums: IntArray, k: Int): IntArray {
        if (k == 0) {
            return intArrayOf()
        }

        val minHeap = PriorityQueue<Pair<Int, Int>>(k, compareBy { it.first })

        for (i in nums.indices) {
            val currentValue = nums[i]
            if (minHeap.size < k) {
                minHeap.offer(Pair(currentValue, i))
            } else {
                if (currentValue > minHeap.peek().first) {
                    minHeap.poll()
                    minHeap.offer(Pair(currentValue, i))
                }
            }
        }

        val resultPairs = minHeap.toList()

        val sortedResult = resultPairs.sortedBy { it.second }

        return sortedResult.map { it.first }.toIntArray()
    }

}

fun main() {
    Solution().maxSubsequence(intArrayOf(50, -75), 2).forEach { print(it) }
    println()
    Solution().maxSubsequence(intArrayOf(-1, -2, 3, 4), 3).forEach { print(it) }
}