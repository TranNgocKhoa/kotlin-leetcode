package lc_443

class Solution {
    fun compress(chars: CharArray): Int {
        if (chars.size <= 1) {
            return 1
        }

        var currentPointer = 0
        var currentCharFirstPosition = 0

        while (currentCharFirstPosition < chars.size) {
            var checkingPosition = currentCharFirstPosition + 1
            while (checkingPosition < chars.size && chars[currentCharFirstPosition] == chars[checkingPosition]) {
                checkingPosition++
            }

            // Set current pointer character is current character.
            chars[currentPointer] = chars[currentCharFirstPosition]
            currentPointer++

            var count = checkingPosition - currentCharFirstPosition
            // If count > 1, then put the number in next characters.
            if (count > 1) {
                val counts = ArrayList<Int>()
                while (count > 0) {
                    counts.add(count % 10)
                    count /= 10

                    currentPointer++
                }
                for (i in 0 until counts.size) {
                    chars[currentPointer - i - 1] = '0' + counts[i]
                }
            }

            // Finished set number appearance for current char (if > 1).
            // Change currentChar to the current checking position's character
            currentCharFirstPosition = checkingPosition
        }

        return currentPointer
    }
}

fun main() {
    val tetCase1 = charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')
    println(Solution().compress(tetCase1))
    println(tetCase1.joinToString { "$it," })

    val tetCase2 = charArrayOf('a', 'a', 'a', 'b', 'b', 'a', 'a')
    println(Solution().compress(tetCase2))
    println(tetCase2.joinToString { "$it," })

    val tetCase3 = charArrayOf('a', 'a')
    println(Solution().compress(tetCase3))
    println(tetCase3.joinToString { "$it," })

    val tetCase4 = charArrayOf('a', 'b', 'c')
    println(Solution().compress(tetCase4))
    println(tetCase4.joinToString { "$it" })


//    println(Solution().compress(charArrayOf('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b')))
//    println(Solution().compress(charArrayOf('a')))
}