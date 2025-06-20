package add_binary

class Solution {
    fun addBinary(a: String, b: String): String {
        var extra = '0'
        val result = StringBuffer()
        val shorter = if (a.length >= b.length) b else a
        val longer = if (a.length >= b.length) a else b
        shorter.forEachIndexed { index, c ->
            if (shorter[shorter.length - index - 1] == '0') {
                if (extra == '0') {
                    result.append(longer[longer.length - index - 1])
                } else {
                    if (longer[longer.length - index - 1] == '1') {
                        result.append('0')
                        extra = '1'
                    } else {
                        result.append(extra)
                        extra = '0'
                    }
                }
            } else if (shorter[shorter.length - index - 1] == '1') {
                if (extra == '0') {
                    if (longer[longer.length - index - 1] == '1') {
                        result.append('0')
                        extra = '1'
                    } else {
                        result.append('1')
                    }
                } else {
                    if (longer[longer.length - index - 1] == '1') {
                        result.append('1')
                    } else {
                        result.append('0')
                    }
                }
            }
        }

        var count = shorter.length
        while (count < longer.length) {
            if (extra == '0') {
                result.append(longer[longer.length - count - 1])
                count++
            } else {
                if (longer[longer.length - count - 1] == '1') {
                    result.append('0')
                    extra = '1'
                    count++
                } else {
                    result.append('1')
                    extra = '0'
                    count++
                }
            }
        }

        if (extra == '1') {
            result.append('1')
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