package lc_2215

class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val num1Set = mutableSetOf<Int>()
        val nums2Set = mutableSetOf<Int>()

        nums1.forEach { num1Set.add(it) }
        nums2.forEach { nums2Set.add(it) }

        nums2.forEach { num1Set.remove(it) }
        nums1.forEach { nums2Set.remove(it) }

        return listOf(num1Set.toList(), nums2Set.toList())
    }
}