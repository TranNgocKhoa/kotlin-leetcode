package lc_1137

class Solution {
    fun tribonacci(n: Int): Int {
        val storeTribo = IntArray(3)
        storeTribo[0] = 0
        storeTribo[1] = 1
        storeTribo[2] = 1

        for (i in 3..n) {
            storeTribo[(i) % 3] = storeTribo[(i - 1) % 3] + storeTribo[(i - 2) % 3] + storeTribo[(i - 3) % 3]
        }

        return storeTribo[n % 3]
    }
}

fun main() {
    Solution().tribonacci(4).let(::println)
}