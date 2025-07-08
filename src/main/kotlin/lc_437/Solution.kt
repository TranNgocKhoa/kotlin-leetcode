package lc_437

import libs.TreeNode
import libs.buildTreeFromArray

class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        if (root == null) return 0

        return pathSumSub(root, targetSum.toLong()) + pathSum(root.right, targetSum) + pathSum(root.left, targetSum)
    }

    fun pathSumSub(root: TreeNode?, targetSum: Long): Int {
        if (root == null) return 0

        return (if (root.`val`.toLong() == targetSum) 1 else 0) +
                pathSumSub(root.right, targetSum - root.`val`) +
                pathSumSub(root.left, targetSum - root.`val`)
    }
}

fun main() {
    val treeNode = buildTreeFromArray(
        arrayOf(
            1000000000,
            1000000000,
            null,
            294967296,
            null,
            1000000000,
            null,
            1000000000,
            null,
            1000000000
        )
    )

    Solution().pathSum(treeNode, 8).let { println(it) }
}