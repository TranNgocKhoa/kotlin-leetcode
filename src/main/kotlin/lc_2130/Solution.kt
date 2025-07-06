package lc_2130

import libs.ListNode
import libs.createLinkedList

class Solution {
    fun pairSum(head: ListNode?): Int {
        var fast = head
        var slow = head

        while (fast != null) {
            slow = slow!!.next!!
            fast = fast.next!!.next
        }

        var lastHalf = reverseList(slow)

        var firstHalf = head
        var maxSum = Int.MIN_VALUE
        while (lastHalf != null) {
            val sum = firstHalf!!.`val` + lastHalf.`val`
            if (sum > maxSum) {
                maxSum = sum
            }
            firstHalf = firstHalf.next
            lastHalf = lastHalf.next
        }

        return maxSum
    }

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
    println(Solution().pairSum(createLinkedList(intArrayOf(5, 4, 2, 1))))
}