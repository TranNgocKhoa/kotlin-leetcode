package spiral_matrix

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        //-100 <= matrix[i][j] <= 100 => mark added cell = -200
        var count = 0
        var direction = 0
        var row = 0
        var col = 0
        var result: ArrayList<Int> = ArrayList()
        while (count < matrix.size * matrix[0].size) {
            if (direction == 0) {
                while (col < matrix[0].size && matrix[row][col] != -200) {
                    result.add(matrix[row][col])
                    count++
                    matrix[row][col] = -200
                    col++
                }
                direction = 1
                col--
                row++
            } else if (direction == 1) {
                while (row < matrix.size && matrix[row][col] != -200) {
                    result.add(matrix[row][col])
                    matrix[row][col] = -200
                    count++
                    row++
                }
                direction = 2
                row--
                col--

            } else if (direction == 2) {
                while (col >= 0 && matrix[row][col] != -200) {
                    result.add(matrix[row][col])
                    matrix[row][col] = -200
                    count++
                    col--
                }
                direction = 3
                col++
                row--
            } else {
                while (row >= 0 && matrix[row][col] != -200) {
                    result.add(matrix[row][col])
                    matrix[row][col] = -200
                    count++
                    row--
                }
                direction = 0
                row++
                col++
            }
        }


        return result
    }
}

fun main() {
    val input = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    Solution().spiralOrder(input).forEach { print("$it ") }
}