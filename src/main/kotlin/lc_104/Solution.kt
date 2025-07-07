package lc_104

import libs.TreeNode

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        return maxOf(
            maxDepth(root.left) + 1,
            maxDepth(root.right) + 1
        )
    }
}