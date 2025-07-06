package libs

class ListNode(var `val`: Int, var next: ListNode? = null) {
    override fun toString(): String {
        return "val = $`val`, next: $next"
    }
}

fun createLinkedList(arr: IntArray): ListNode? {
    if (arr.isEmpty()) {
        return null
    }

    var head: ListNode? = null
    var current: ListNode? = null

    for (value in arr) {
        val newNode = ListNode(value)
        if (head == null) {
            head = newNode
            current = head
        } else {
            current?.next = newNode
            current = newNode
        }
    }
    return head
}