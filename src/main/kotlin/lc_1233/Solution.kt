package lc_1233

class Solution {
    fun removeSubfolders(folder: Array<String>): List<String> {
        val result = mutableListOf<String>()
        val sorted = folder.sorted()
        var i = 0
        while (i < sorted.size) {
            val currentFolder = sorted[i]
            var j = i + 1
            while (j <= sorted.lastIndex) {
                if (sorted[j].contains(currentFolder) && sorted[j].startsWith("$currentFolder/")) {
                    j++
                } else {
                    break
                }
            }
            result.add(currentFolder)
            i = j
        }

        return result
    }
}

fun main() {
    println(Solution().removeSubfolders(arrayOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f")))
    println(Solution().removeSubfolders(arrayOf("/a/a", "/a/ab")))
}