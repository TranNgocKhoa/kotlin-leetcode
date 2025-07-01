package lc_3330

class Solution {
    fun possibleStringCount(word: String): Int {
        var result = 1 // Case no mistake
        for (i in 1..word.length - 1) {
            if (word[i - 1] == word[i]) {
                result += 1 // a repeat is a mistake
            }
        }

        return result

//        val charCount = ArrayList<Int>()
//        charCount.add(1)
//        for (i in 0 until word.length - 1) {
//            if (word[i] == word[i + 1]) {
//                charCount[charCount.size - 1]++
//            } else {
//                charCount.add(1)
//            }
//        }
//
//        var result = 1 // case no wrong all
//        for (i in charCount) {
//            if (i >= 2) {
//                result += (i - 1) // remove case no wrong
//            }
//        }
//
//        return result
    }
}