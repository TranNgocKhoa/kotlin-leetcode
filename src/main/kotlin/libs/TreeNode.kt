package libs

import java.util.LinkedList
import java.util.Queue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun buildTreeFromArray(arr: Array<Int?>): TreeNode? {
    // If the array is empty or the first element is null, no tree can be formed.
    if (arr.isEmpty() || arr[0] == null) {
        return null
    }

    // Create the root node from the first element of the array.
    val root = TreeNode(arr[0]!!) // '!!' asserts that arr[0] is not null, which we've checked.
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root) // Add the root to the queue for level-order processing.

    var i = 1 // Start index for processing children in the array.

    // Continue as long as there are nodes in the queue to process
    // and there are elements left in the array.
    while (queue.isNotEmpty() && i < arr.size) {
        val currentNode = queue.poll() // Get the current node from the front of the queue.

        // Process the left child
        if (i < arr.size && arr[i] != null) {
            val leftNode = TreeNode(arr[i]!!)
            currentNode.left = leftNode
            queue.add(leftNode) // Add the new left child to the queue.
        }
        i++ // Move to the next element in the array.

        // Process the right child
        if (i < arr.size && arr[i] != null) {
            val rightNode = TreeNode(arr[i]!!)
            currentNode.right = rightNode
            queue.add(rightNode) // Add the new right child to the queue.
        }
        i++ // Move to the next element in the array.
    }

    return root // Return the root of the constructed tree.
}