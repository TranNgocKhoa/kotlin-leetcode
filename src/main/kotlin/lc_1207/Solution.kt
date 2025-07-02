package lc_1207

class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val numberOfOccurrences = HashMap<Int, Int>()
        arr.forEach {
            val orDefault = numberOfOccurrences.getOrDefault(it, 0)
            numberOfOccurrences[it] = (orDefault + 1)
        }

        val setOfOccurrences = HashSet<Int>()

        for (entry in numberOfOccurrences) {
            if (setOfOccurrences.contains(entry.value)) {
                return false
            }
            setOfOccurrences.add(entry.value)
        }

        return true
    }
}