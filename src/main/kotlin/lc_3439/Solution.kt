package lc_3439

import kotlin.math.max

class Solution {
    fun maxFreeTime(eventTime: Int, k: Int, startTime: IntArray, endTime: IntArray): Int {
        val n = endTime.size
        val nums = IntArray(n + 1) // n+1 intervals in total
        nums[0] = startTime[0]
        for (i in 1..<n) {
            nums[i] = startTime[i] - endTime[i - 1]
        }
        nums[n] = eventTime - endTime[n - 1]
        var ans = 0
        var currentFreeTime = 0
        for (i in 0..n) {
            currentFreeTime += nums[i]
            if (i >= k) { // maximum window size = k
                ans = max(ans, currentFreeTime)
                currentFreeTime -= nums[i - k] // remove first item
            }
        }
        return ans
    }
}