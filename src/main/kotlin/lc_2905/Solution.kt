package lc_2905

import libs.ListNode
import libs.createLinkedList

class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        var size = 1
        var fast = head

        while (fast?.next != null) {
            fast = fast.next
            size++
        }

        if (size == 1) {
            return null
        }

        val dummyHead = ListNode(0)
        dummyHead.next = head

        fast = head?.next
        var slow = head
        var i = 1
        while (i < size / 2) {
            fast = fast?.next
            slow = slow?.next
            i++
        }

        slow?.next = fast?.next

        return dummyHead.next
    }
}

fun main() {
    println(Solution().deleteMiddle(createLinkedList(intArrayOf(1, 3, 4, 7, 1, 2, 6))).toString())
}