package lc_437

import libs.TreeNode
import libs.buildTreeFromArray


class EffectiveSolution {
    private val prefixSumCounts: MutableMap<Long, Int> = HashMap()
    private var targetSum = 0

    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        prefixSumCounts.put(0L, 1) // always has a path from root that sum == 0
        this.targetSum = targetSum
        return dfs(root, 0)
    }

    private fun dfs(node: TreeNode?, currentSum: Long): Int {
        var currentSum = currentSum
        if (node == null) {
            return 0
        }
        currentSum += node.`val`
        var totalPaths: Int = prefixSumCounts.getOrDefault(currentSum - targetSum, 0)

        // At this node, we have sum of path = currentSum, we update prefixSumCounts[currentSum]++
        prefixSumCounts[currentSum] = prefixSumCounts.getOrDefault(currentSum, 0) + 1

        totalPaths += dfs(node.left, currentSum)
        totalPaths += dfs(node.right, currentSum)

        // at the end of recursive, back to the parent path, node doesn't in the path, so remove back -1
        prefixSumCounts[currentSum] = prefixSumCounts.getOrDefault(currentSum, 0) - 1

        return totalPaths
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
//    EffectiveSolution().pathSum(treeNode, 8).let { println(it) } // 0

    val treeNode2 = buildTreeFromArray(
        arrayOf(
            5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1
        )
    )
    EffectiveSolution().pathSum(treeNode2, 22).let { println(it) } // 3

    val treeNode3 = buildTreeFromArray(
        arrayOf(
            0
        )
    )
    EffectiveSolution().pathSum(treeNode3, 0).let { println(it) } // 1


}