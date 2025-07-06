package lc_649

class Solution {
    fun predictPartyVictory(senate: String): String {
        val queue = ArrayDeque<Char>()

        var countR = 0
        var countD = 0
        senate.forEach {
            queue.add(it)
            if (it == 'D') {
                countD++
            } else {
                countR++
            }
        }

        var banDCount = 0
        var banRCount = 0
        while (queue.size > 1 && (countR > 0 && countD > 0)) {
            val person = queue.removeFirst()
            if (person == 'D') {
                if (banDCount > 0) {
                    banDCount--
                    countD--
                } else {
                    banRCount++
                    queue.addLast(person)
                }
            } else if (person == 'R') {
                if (banRCount > 0) {
                    banRCount--
                    countR--
                } else {
                    banDCount++
                    queue.addLast(person)
                }
            }
        }

        return if (queue.first() == 'D') "Dire" else "Radiant"
    }
}

fun main() {
    val solution = Solution()
    solution.predictPartyVictory("RD").let { println(it) }
    solution.predictPartyVictory("RDD").let { println(it) }
    solution.predictPartyVictory("DDRRR").let { println(it) }
}