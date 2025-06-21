package zigzag_conversion

class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }

        var goDown = false // for starting check
        var row = 0
        val result = MutableList(numRows) { StringBuilder() }

        repeat(numRows) {
            result.add(StringBuilder())
        }

        for (ch in s) {
            result[row].append(ch)
            if (row == numRows - 1 || row == 0) { // first round, row == 0, change direction. false -> true: goDown
                goDown = !goDown
            }

            row += if (goDown) 1 else -1
        }

        return result.joinToString(separator = "")
    }
}

fun main() {
    println(Solution().convert("PAYPALISHIRING", 3))
//    println(Solution().convert("AB", 1))

}