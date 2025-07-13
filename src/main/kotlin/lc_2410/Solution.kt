package lc_2410

class Solution {
    fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
        players.sort()
        trainers.sort()

        var count = 0
        var trainerIndex = 0
        var playerIndex = 0

        while (playerIndex < players.size && trainerIndex < trainers.size) {
            if (players[playerIndex] <= trainers[trainerIndex]) {
                count++
                playerIndex++
            }
            trainerIndex++
        }

        return count
    }
}

fun main() {
    Solution().matchPlayersAndTrainers(intArrayOf(4, 7, 9), intArrayOf(8, 2, 5, 4)).let(::println)
}