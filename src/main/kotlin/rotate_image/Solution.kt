package rotate_image

class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        // transpose
        for (row: Int in 0 until matrix.size) {
            for (col: Int in 0 until row) {
                val temp = matrix[row][col]
                matrix[row][col] = matrix[col][row]
                matrix[col][row] = temp
            }
        }

        // reverse columns
        //[[1,4,7],
        // [2,5,8],
        // [3,6,9]]
        for (row: Int in 0 until matrix.size) {
            for (col: Int in 0 until matrix[0].size / 2) {
                val temp = matrix[row][col]
                matrix[row][col] = matrix[row][matrix[0].size - 1 - col]
                matrix[row][matrix[0].size - 1 - col] = temp
            }
        }
    }
}