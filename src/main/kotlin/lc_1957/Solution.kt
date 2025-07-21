package lc_1957

class Solution {
    fun makeFancyString(s: String): String {
        var lasChar = s[0]
        var count = 1

        val result = StringBuilder().append(lasChar)
        for (i in 1 until s.length) {
            if (count == 2 && s[i] == lasChar) {
                continue
            } else if (s[i] != lasChar) {
                count = 1
            } else {
                count++
            }
            lasChar = s[i]
            result.append(lasChar)
        }

        return result.toString()
    }
}