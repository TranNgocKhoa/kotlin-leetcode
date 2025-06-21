package climbing_stairs

class Solution {


    fun climbStairs(n: Int): Int {
        if (n <= 2) {
            return n
        }

        var prev1 = 1
        var prev2 = 2
        var steps = 0
        repeat(n - 2) {
            steps = prev1 + prev2
            prev1 = prev2
            prev2 = steps
        }

        return steps
    }

    fun climbStairs1(n: Int): Int {
        val climbsSteps = IntArray(n + 1)
        climbsSteps[0] = 0
        for (i in 1..n) {
            if (i <= 2) {
                climbsSteps[i] = i
            } else {
                climbsSteps[i] = climbsSteps[i - 1] + climbsSteps[i - 2]
            }

        }

        return climbsSteps[n]
    }
}

fun main() {
    print(Solution().climbStairs(4))
}