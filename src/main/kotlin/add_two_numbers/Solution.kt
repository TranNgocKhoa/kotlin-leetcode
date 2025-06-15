package add_two_numbers

import libs.ListNode

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var current: ListNode = dummyHead

        var p1 = l1
        var p2 = l2

        var carry = 0

        while (p1 !== null || p2 !== null || carry != 0) {
            val val1 = p1?.`val` ?: 0
            val val2 = p2?.`val` ?: 0

            val sum = val1 + val2 + carry

            val digit = sum % 10
            carry = sum / 10

            current.next = ListNode(digit)
            current = current.next!! // assign current.next (non null) to current;

            p1 = p1?.next
            p2 = p2?.next
        }

        return dummyHead.next
    }
}

fun main() {
    val solution = Solution()

    println(solution.addTwoNumbers(ListNode(0), ListNode(0)))
}