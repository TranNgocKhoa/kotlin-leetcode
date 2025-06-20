package add_binary

class Solution {
    fun addBinary(a: String, b: String): String {
        var carry = 0
        val result = StringBuilder()
        var aIndex = a.length - 1
        var bIndex = b.length - 1
        while (carry != 0 || bIndex >= 0 || aIndex >= 0) {
            val sum = (if (aIndex >= 0) a[aIndex--] - '0' else 0) +
                    (if (bIndex >= 0) b[bIndex--] - '0' else 0) +
                    carry

            result.append(sum % 2)
            carry = sum / 2
        }

        return result.reverse().toString()
    }
}

fun main() {
//    print(Solution().addBinary("11", "1"))
//    print(Solution().addBinary("1010", "1011"))
//    print(Solution().addBinary("100", "110010"))
    print(Solution().addBinary("101111", "10"))
}