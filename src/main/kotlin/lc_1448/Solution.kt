package lc_1448

import libs.TreeNode

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        fun countGoodNodes(node: TreeNode?, maxValue: Int): Int {
            if (node == null) {
                return 0
            }

            return if (maxValue <= node.`val`) {
                1 + countGoodNodes(node.left, node.`val`) + countGoodNodes(node.right, node.`val`)
            } else {
                countGoodNodes(node.left, maxValue) + countGoodNodes(node.right, maxValue)
            }
        }

        return 1 + countGoodNodes(root.left, root.`val`) + countGoodNodes(root.right, root.`val`)
    }
}