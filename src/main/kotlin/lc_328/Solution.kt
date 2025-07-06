package lc_328

import libs.ListNode
import libs.createLinkedList

class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        var oddPointer: ListNode? = head
        var evenPointer: ListNode? = head.next
        val headOfEvenNodes: ListNode? = evenPointer
        while (evenPointer != null && evenPointer.next != null) {
            oddPointer?.next = evenPointer.next
            oddPointer = oddPointer?.next

            evenPointer.next = oddPointer?.next
            evenPointer = evenPointer.next
        }

        oddPointer?.next = headOfEvenNodes

        return head
    }
}

fun main() {
    println(Solution().oddEvenList(createLinkedList(intArrayOf(1, 2, 3, 4, 5))).toString())
}