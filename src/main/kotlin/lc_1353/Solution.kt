package lc_1353

import java.util.PriorityQueue

class Solution {
    fun maxEvents(events: Array<IntArray>): Int {
        events.sortWith(compareBy({ it[0] }, { it[1] }))
        val startDay: Int = events[0][0]
        val endDay: Int = events.maxOf { it[1] }

        var attended = 0
        // end day larger will be later
        val dayPriorityQueue = PriorityQueue<Int>()
        var eventIndex = 0
        for (day in startDay..endDay) {
            while (dayPriorityQueue.isNotEmpty() && dayPriorityQueue.peek() < day) {
                dayPriorityQueue.poll()
            }

            while (eventIndex < events.size && events[eventIndex][0] <= day && events[eventIndex][1] >= day) {
                // add new events that started in current day
                dayPriorityQueue.offer(events[eventIndex++][1])
            }

            if (dayPriorityQueue.isNotEmpty()) {
                attended++
                dayPriorityQueue.poll()
            }
        }

        return attended
    }
}

fun main() {
    Solution().maxEvents(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )


    )
}