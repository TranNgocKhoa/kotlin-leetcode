package kids_with_candies

class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        if (candies.isEmpty()) {
            return emptyList()
        }

        val max = candies.max()

        return candies.map { it + extraCandies >= max }
    }
}

fun main() {
    val candies = intArrayOf(2, 3, 5, 1, 3)
    val extraCandies = 3

    Solution().kidsWithCandies(candies, extraCandies).forEach { println(it) }
}