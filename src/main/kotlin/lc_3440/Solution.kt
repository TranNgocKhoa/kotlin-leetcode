package lc_3440

import kotlin.math.max

class Solution {
    fun maxFreeTime(eventTime: Int, startTime: IntArray, endTime: IntArray): Int {
        val n = startTime.size
        val pre = IntArray(n)
        val suf = IntArray(n)

        pre[0] = startTime[0]
        suf[n - 1] = eventTime - endTime[n - 1]

        for (i in 1..<n) {
            pre[i] = max(pre[i - 1], startTime[i] - endTime[i - 1])
        }

        for (i in n - 2 downTo 0) {
            suf[i] = max(suf[i + 1], startTime[i + 1] - endTime[i])
        }

        var ans = 0
        for (i in 0..<n) {
            val l = if (i == 0) 0 else endTime[i - 1]
            val r = if (i == n - 1) eventTime else startTime[i + 1]
            val w = endTime[i] - startTime[i]
            ans = max(ans, r - l - w)

            if (i > 0 && pre[i - 1] >= w) {
                ans = max(ans, r - l)
            } else if (i + 1 < n && suf[i + 1] >= w) {
                ans = max(ans, r - l)
            }
        }

        return ans
    }
}