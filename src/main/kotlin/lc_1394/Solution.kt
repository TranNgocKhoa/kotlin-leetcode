package lc_1394

class Solution {
    fun findLucky(arr: IntArray): Int {
        val freqMap = HashMap<Int, Int>()

        arr.forEach {
            freqMap[it] = freqMap.getOrDefault(it, 0) + 1
        }
        var lucky = -1
        freqMap.forEach {
            if (it.value == it.key) {
                if (lucky < it.key) {
                    lucky = it.key
                }
            }
        }

        return lucky
    }
}