package lc_1751

import java.util.*
import kotlin.math.max


class Solution {

    private lateinit var events: Array<IntArray>
    private lateinit var f: Array<IntArray>
    private var n = 0

    fun maxValue(events: Array<IntArray>, k: Int): Int {
        Arrays.sort(events, Comparator { a: IntArray?, b: IntArray? -> a!![0] - b!![0] })
        this.events = events
        n = events.size
        f = Array(n) { IntArray(k + 1) }
        return dfs(0, k)
    }

    private fun dfs(i: Int, k: Int): Int {
        if (i >= n || k <= 0) {
            return 0
        }
        if (f[i][k] != 0) {
            return f[i][k]
        }
        val j = search(events, events[i][1], i + 1)
        val ans = max(dfs(i + 1, k), dfs(j, k - 1) + events[i][2])
        return ans.also { f[i][k] = it }
    }

    private fun search(events: Array<IntArray>, x: Int, lo: Int): Int {
        var l = lo
        var r = n
        while (l < r) {
            val mid = (l + r) shr 1
            if (events[mid][0] > x) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return l
    }
}