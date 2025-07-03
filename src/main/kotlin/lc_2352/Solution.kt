package lc_2352

class Solution {
    fun equalPairs(grid: Array<IntArray>): Int {
        val hashRow = HashMap<List<Int>, Int>()

        var rIndex = 0
        for (row in grid) {
            hashRow[row.toList()] = hashRow.getOrDefault(row.toList(), 0) + 1
            rIndex++
        }


        var count = 0
        for (i in 0 until grid.size) {
            val sb = mutableListOf<Int>()
            for (j in 0 until grid.size) {
                sb.add(grid[j][i])
            }

            if (hashRow.containsKey(sb)) {
                count += hashRow[sb]!!
            }
        }

        return count
    }
}

fun main() {
//    println(
//        Solution().equalPairs(
//            arrayOf(
//                intArrayOf(3, 2, 1),
//                intArrayOf(1, 7, 6),
//                intArrayOf(2, 7, 7),
//            )
//        )
//    )

    println(
        Solution().equalPairs(
            arrayOf(
                intArrayOf(3, 1, 2, 2),
                intArrayOf(1, 4, 4, 5),
                intArrayOf(2, 4, 2, 2),
                intArrayOf(2, 4, 2, 2),
            )
        )
    )

    //3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]
}