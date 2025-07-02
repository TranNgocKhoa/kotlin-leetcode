package lc_1732

class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var maxHeight = 0
        var height = 0

        for (i in 0 until gain.size - 1) {
            height += gain[i]
            if (height > maxHeight) {
                maxHeight = height
            }
        }

        return maxHeight
    }
}