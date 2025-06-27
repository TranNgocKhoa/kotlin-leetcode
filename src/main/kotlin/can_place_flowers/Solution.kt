package can_place_flowers

class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if (flowerbed.isEmpty()) return false

        if (flowerbed.size == 1) {
            if (n == 0) {
                return true
            }
            return flowerbed[0] == 0 && n == 1
        }
        var count = 0
        var i = 0
        while (count < n && i <= flowerbed.size - 1) {
            if (i == 0) {
                if (flowerbed[i] + flowerbed[1] == 0) {
                    flowerbed[i] = 1
                    i++
                    count++
                }
            } else if (i == flowerbed.size - 1) {
                if (flowerbed[i] + flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1
                    i++
                    count++
                }
            } else {
                if (flowerbed[i - 1] + flowerbed[i] + flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1
                    i++
                    count++
                }
            }

            i++
        }

        return count == n
    }


    fun canPlaceFlowers_naive(flowerbed: IntArray, n: Int): Boolean {
        var remains = n
        var nextIndex = 0
        while (nextIndex <= flowerbed.size - 1 && remains > 0) {
            if (nextIndex == flowerbed.size - 1 && flowerbed[nextIndex] == 1) {
                break
            }

            if (nextIndex == flowerbed.size - 1 && flowerbed[nextIndex] == 0) {
                remains--
                break
            }

            if (flowerbed[nextIndex] == 0 && flowerbed[nextIndex + 1] == 0) {
                flowerbed[nextIndex] = 1
                nextIndex += 2
                remains--
            } else if (flowerbed[nextIndex] == 0 && flowerbed[nextIndex + 1] == 1) {
                nextIndex = nextIndex + 1
            } else if (flowerbed[nextIndex] == 1 && flowerbed[nextIndex + 1] == 0) {
                nextIndex = nextIndex + 2
            } else {
                return false
            }
        }

        return remains == 0
    }
}

fun main() {
//    println(Solution().canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1))
//    println(Solution().canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 2))
//    println(Solution().canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1, 0, 0), 2))
//    println(Solution().canPlaceFlowers(intArrayOf(0, 0, 1, 0, 0), 1))
    println(Solution().canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1, 0, 0), 2))
}