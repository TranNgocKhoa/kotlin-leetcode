package where_will_the_ball_fall

class Solution {
    fun findBall(grid: Array<IntArray>): IntArray {
        if (grid[0].size == 1) {
            return intArrayOf(-1)
        }
        val ballPoses = IntArray(grid[0].size)
        for (i in grid[0].indices) {
            ballPoses[i] = -1
        }

        // grid[row][col] == -1 => /
        // grid[row][col] == 1  => \
        val numberOfCol = grid[0].size
        val numberOfRow = grid.size
        for (i in grid[0].indices) {
            var row = -1
            var col = i

            while (row < grid.size - 1 && row < numberOfRow - 1) {
                if (col == 0) {
                    if (grid[row + 1][col] == -1) {
                        ballPoses[i] = -1
                        break
                    } else {
                        if (grid[row + 1][1] == -1) {
                            ballPoses[i] = -1
                            break
                        } else {
                            col++
                            row++
                            continue
                        }
                    }
                } else if (col == numberOfCol - 1) {
                    if (grid[row + 1][col] == 1) {
                        ballPoses[i] = -1
                        break
                    } else {
                        if (grid[row + 1][col - 1] == 1) {
                            ballPoses[i] = -1
                            break
                        } else {
                            col--
                            row++
                            continue
                        }
                    }
                } else {
                    if (grid[row + 1][col] == 1 && grid[row + 1][col + 1] == -1) {
                        ballPoses[i] = -1
                        break
                    } else if (grid[row + 1][col] == 1 && grid[row + 1][col + 1] == 1) {
                        row++
                        col++
                        continue
                    } else if (grid[row + 1][col] == -1 && grid[row + 1][col - 1] == 1) {
                        ballPoses[i] = -1
                        break
                    } else if (grid[row + 1][col] == -1 && grid[row + 1][col - 1] == -1) {
                        row++
                        col--
                        continue
                    }
                }
            }

            if (row == numberOfRow - 1) {
                ballPoses[i] = col
            }

        }


        return ballPoses
    }
}

fun main() {
//    val grid: Array<IntArray> = arrayOf(
//        intArrayOf(1, 1, 1, -1, -1),
//        intArrayOf(1, 1, 1, -1, -1),
//        intArrayOf(-1, -1, -1, 1, 1),
//        intArrayOf(1, 1, 1, 1, -1),
//        intArrayOf(-1, -1, -1, -1, -1)
//    )

    val grid: Array<IntArray> = arrayOf(
        intArrayOf(1),
    )

    val ballPos = Solution().findBall(grid)
    for (i in ballPos) {
        print("$i ")
    }
}