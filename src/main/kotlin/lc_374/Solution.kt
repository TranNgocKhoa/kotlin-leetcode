package lc_374

abstract class GuessGame {
    abstract fun guessNumber(n: Int): Int

    fun guess(num: Int): Int {
        return 1
    }
}

class Solution : GuessGame() {
    override fun guessNumber(n: Int): Int {
        return guessNumberIn(0, n)
    }

    fun guessNumberIn(start: Int, end: Int): Int {
        val guess: Int = start + (end - start) / 2
        val result = guess(guess)
        return if (result == 0) {
            guess
        } else if (result == 1) {
            guessNumberIn(guess + 1, end)
        } else {
            guessNumberIn(start, guess - 1)
        }
    }
}