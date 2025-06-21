package rotate_list

import libs.ListNode

class Solution {

    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null

        val size = getSize(head)

        val actualK = k % size
        if (actualK == 0) {
            return head
        }

        val dummyHead = ListNode(-1)
        dummyHead.next = head

        val newTail = getKthNode(head, size - actualK - 1)
        val newHead = newTail?.next

        // set next for newTail = null
        newTail?.next = null

        // find current tail
        val findOldTail = getCurrentTail(newHead)
        // set current tail next to old head
        findOldTail?.next = head

        return newHead
    }

    private fun getCurrentTail(newHead: ListNode?): ListNode? {
        var dummyNode = newHead

        while (dummyNode?.next != null) {
            dummyNode = dummyNode.next
        }

        return dummyNode
    }

    private fun getSize(head: ListNode?): Int {
        if (head == null) return 0

        var checkSize = ListNode(0)
        checkSize.next = head
        var size = 0
        while (checkSize.next != null) {
            checkSize = checkSize.next!!
            size++
        }

        return size
    }

    fun getKthNode(head: ListNode?, k: Int): ListNode? {
        var steps = k
        var node: ListNode? = head
        while (steps > 0) {
            steps--
            node = node?.next
        }

        return node
    }


    fun rotateRight_V1(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null

        val dummyHead = ListNode(0)
        dummyHead.next = head

        var checkSize = ListNode(0)
        checkSize.next = head
        var size = 0
        while (checkSize.next != null) {
            checkSize = checkSize.next!!
            size++
        }

        var actualRotate = k % size

        while (actualRotate > 0) {
            var dummy = ListNode(0)
            dummy.next = dummyHead.next

            repeat(size - 1) {
                dummy = dummy.next!!
            }

            swap(dummyHead.next!!, dummy.next!!, dummy, dummyHead)
            actualRotate--
        }

        return dummyHead.next
    }

    // for rotateRight_V1
    fun swap(a: ListNode, b: ListNode, prev: ListNode, head: ListNode): Unit {
        b.next = a
        prev.next = null
        head.next = b
    }
}

fun main() {
    var rotateRight = Solution()
        .rotateRight(
            ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))), 2
        )

    while (rotateRight != null) {
        print("${rotateRight.`val`} ")
        rotateRight = rotateRight.next
    }


}