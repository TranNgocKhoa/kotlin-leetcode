package lru_cache

class LRUCache(val capacity: Int) {
    class Node(
        val key: Int, // for remove node in cache
        var value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )

    var head: Node = Node(0, 0)
    var tail: Node = Node(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    var map: HashMap<Int, Node> = HashMap()

    fun get(key: Int): Int {
        if (map.containsKey(key)) {
            val node = map.get(key)!!
            removeNode(node)
            addHead(node)

            return node.value
        }

        return -1
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            val node: Node = map.get(key)!!
            node.value = value
            removeNode(node)
            addHead(node)
        } else {
            val newNode = Node(key, value)
            map.put(key, newNode)
            addHead(newNode)

            if (map.size > capacity) {
                val lruNode = tail.prev
                removeNode(lruNode!!)
                map.remove(lruNode.key)
            }
        }
    }

    private fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun addHead(node: Node) {
        node.next = head.next
        node.prev = head
        head.next?.prev = node
        head.next = node
    }
}

fun main() {

    println("--- Test Case 1: Capacity = 2 ---")
    val cache1 = LRUCache(2)

    println("Put(1, 1)")
    cache1.put(1, 1)

    println("Put(2, 2)")
    cache1.put(2, 2)

    println("Get(1): ${cache1.get(1)}")

    println("Put(3, 3)")
    cache1.put(3, 3)

    println("Get(2): ${cache1.get(2)}")

    println("Put(4, 4)")
    cache1.put(4, 4)

    println("Get(1): ${cache1.get(1)}")
    println("Get(3): ${cache1.get(3)}")
    println("Get(4): ${cache1.get(4)}")

    println("\n--- Test Case 2: Capacity = 1 ---")
    val cache2 = LRUCache(1)

    println("Put(1, 1)")
    cache2.put(1, 1)

    println("Get(1): ${cache2.get(1)}")

    println("Put(2, 2)")
    cache2.put(2, 2)

    println("Get(1): ${cache2.get(1)}")

    println("Get(2): ${cache2.get(2)}")

    println("\n--- Test Case 3: Empty Cache and Update ---")
    val cache3 = LRUCache(3)
    println("Get(5): ${cache3.get(5)}")

    println("Put(1, 10)")
    cache3.put(1, 10)
    println("Put(2, 20)")
    cache3.put(2, 20)
    println("Put(3, 30)")
    cache3.put(3, 30)

    println("Get(2): ${cache3.get(2)}")

    println("Put(1, 100)")
    cache3.put(1, 100)

    println("Get(1): ${cache3.get(1)}")
    println("Put(4, 40)")
    cache3.put(4, 40)

    println("Get(3): ${cache3.get(3)}")
    println("Get(4): ${cache3.get(4)}")
}