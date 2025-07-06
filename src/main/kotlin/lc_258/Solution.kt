package lc_258

class Solution {
    fun addDigits(num: Int): Int {
        // 38 -> 3 + 8 -> 11 -> 2
        // 22 -> 2 + 2 -> 4
        // 158 -> 1 + 5 + 8 -> 14 -> 6

        // 0  1  2  3  4  5  6  7  8  9
        //    10 11 12 13 14 15 15 17 18
        //    19

        // if (num <= 9) return num % 10

        // if (num % 9 == 0) {
        //     return 9
        // }

        // return (num) % 9

        //What are all the possible results?
        //How do they occur, periodically or randomly?

        //https://en.wikipedia.org/wiki/Digital_root
        return ((num - 1) % 9) + 1
    }
}