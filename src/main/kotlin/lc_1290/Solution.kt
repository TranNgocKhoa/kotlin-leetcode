package lc_1290

import libs.ListNode
import libs.createLinkedList
import kotlin.math.pow

class Solution {
    fun getDecimalValue(head: ListNode?): Int {
        if (head == null) {
            return 0
        }
        var size = 0
        var dummy: ListNode? = ListNode(0)
        dummy?.next = head
        while (dummy?.next != null) {
            size++
            dummy = dummy.next
        }

        var value = 0
        dummy = head
        while (dummy != null) {
            value += dummy.`val` * 2.toDouble().pow(size.toDouble() - 1).toInt()
            size--
            dummy = dummy.next
        }

        return value
    }
}

fun main() {
    val fromArray = createLinkedList(intArrayOf(1, 0, 1))

    Solution().getDecimalValue(fromArray).let { println(it) }
}