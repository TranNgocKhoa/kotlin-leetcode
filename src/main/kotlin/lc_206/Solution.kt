package lc_206

import libs.ListNode
import libs.createLinkedList

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var newHead: ListNode? = null
        var currentNode: ListNode? = head

        while (currentNode != null) {
            val nextNode = currentNode.next

            currentNode.next = newHead // assign current node.next to latest reordered part
            newHead = currentNode // then newHead should the counted from currentNode

            currentNode = nextNode // move to the next node
        }

        return newHead
    }
}

fun main() {
    println(Solution().reverseList(createLinkedList(intArrayOf(1, 2, 3, 4))))
}