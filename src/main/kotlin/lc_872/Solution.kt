package lc_872

import libs.TreeNode

class Solution {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val root1Leaf = ArrayList<Int>()
        val root2Leaf = ArrayList<Int>()

        fun collectLeafs(node: TreeNode?, leafs: ArrayList<Int>) {
            if (node == null) {
                return
            }

            if (node.left == null && node.right == null) {
                leafs.add(node.`val`)
            }
            collectLeafs(node.left, leafs)
            collectLeafs(node.right, leafs)
        }

        collectLeafs(root1, root1Leaf)
        collectLeafs(root2, root2Leaf)
        return root1Leaf == root2Leaf
    }
}