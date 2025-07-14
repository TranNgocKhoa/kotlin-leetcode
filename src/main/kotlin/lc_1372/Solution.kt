package lc_1372

import libs.TreeNode
import libs.buildTreeFromArray
import kotlin.math.max

class Solution {
    var pathLength: Int = 0
    private fun dfs(node: TreeNode?, goLeft: Boolean, steps: Int) {
        if (node == null) {
            return
        }
        pathLength = max(pathLength, steps)
        if (goLeft) {
            dfs(node.left, false, steps + 1)
            dfs(node.right, true, 1)
        } else {
            dfs(node.left, false, 1)
            dfs(node.right, true, steps + 1)
        }
    }

    fun longestZigZag(root: TreeNode?): Int {
        dfs(root?.right, true, 1)
        dfs(root?.left, false, 1)
        return pathLength
    }
}

fun main() {
    val buildTreeFromArray = buildTreeFromArray(arrayOf(1, 1, 1, null, 1, null, null, 1, 1, null, 1))
    Solution().longestZigZag(buildTreeFromArray).let { println(it) }


    val buid = buildTreeFromArray(arrayOf(1, 1, 1, 1, 1, 1, 1, null, null, null, null, null, null, 1, 1, null, null, 1))
    Solution().longestZigZag(buid).let { println(it) }
}