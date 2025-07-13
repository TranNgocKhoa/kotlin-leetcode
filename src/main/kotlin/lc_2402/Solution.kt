package lc_2402

import java.util.*


class Solution {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        Arrays.sort(meetings, Comparator { a: IntArray, b: IntArray -> a[0] - b[0] })
        val busy =
            PriorityQueue(Comparator { a: IntArray, b: IntArray -> if (a[0] == b[0]) a[1] - b[1] else a[0] - b[0] })
        val idle = PriorityQueue<Int?>()
        for (i in 0..<n) {
            idle.offer(i)
        }
        val cnt = IntArray(n)
        for (v in meetings) {
            val s = v[0]
            val e = v[1]
            while (!busy.isEmpty() && busy.peek()[0] <= s) {
                idle.offer(busy.poll()[1])
            }
            var i = 0
            if (!idle.isEmpty()) {
                i = idle.poll()!!
                busy.offer(intArrayOf(e, i))
            } else {
                val x = busy.poll()
                i = x[1]
                busy.offer(intArrayOf(x[0] + e - s, i))
            }
            ++cnt[i]
        }
        var ans = 0
        for (i in 0..<n) {
            if (cnt[ans] < cnt[i]) {
                ans = i
            }
        }
        return ans
    }
}