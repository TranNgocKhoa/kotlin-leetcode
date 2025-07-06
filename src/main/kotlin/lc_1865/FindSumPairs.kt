package lc_1865

class FindSumPairs(val nums1: IntArray, val nums2: IntArray) {
    val hashMap1 = HashMap<Int, Int>()
    val hashMap2 = HashMap<Int, Int>()

    init {
        nums1.forEachIndexed { index, i ->
            hashMap1[i] = hashMap1.getOrDefault(i, 0) + 1
        }

        nums2.forEachIndexed { index, i ->
            hashMap2[i] = hashMap2.getOrDefault(i, 0) + 1
        }
    }

    fun add(index: Int, `val`: Int) {
        if (hashMap2.containsKey(nums2[index])) {
            hashMap2[nums2[index]] = hashMap2[nums2[index]]!! - 1
            if (hashMap2[nums2[index]] == 0) {
                hashMap2.remove(nums2[index])
            }
        }

        nums2[index] += `val`
        hashMap2[nums2[index]] = hashMap2.getOrDefault(nums2[index], 0) + 1
    }

    fun count(tot: Int): Int {
        var count = 0
        hashMap1.keys.forEach { key ->
            if (hashMap2.containsKey(tot - key)) {
                count += hashMap1[key]!!.times(hashMap2[tot - key]!!)
            }
        }

        return count
    }
}

fun main() {
    val findSumPairs = FindSumPairs(
        intArrayOf(1, 1, 2, 2, 2, 3),
        intArrayOf(1, 4, 5, 2, 5, 4)
    )
    println("Initial nums2: ${findSumPairs.nums2.contentToString()}")
    println("--------------------")

    // First count call
    val count1 = findSumPairs.count(7)
    println("count(7): $count1") // Expected: 8
    println("--------------------")

    // First add call
    findSumPairs.add(3, 2)
    println("add(3, 2)")
    println("nums2 after add: ${findSumPairs.nums2.contentToString()}")
    println("--------------------")


    // Second count call
    val count2 = findSumPairs.count(8)
    println("count(8): $count2") // Expected: 2
    println("--------------------")

    // Third count call
    val count3 = findSumPairs.count(4)
    println("count(4): $count3") // Expected: 1
    println("--------------------")

    // Second and third add calls
    findSumPairs.add(0, 1)
    println("add(0, 1)")
    findSumPairs.add(1, 1)
    println("add(1, 1)")
    println("nums2 after adds: ${findSumPairs.nums2.contentToString()}")
    println("--------------------")

    // Final count call
    val count4 = findSumPairs.count(7)
    println("count(7): $count4") // Expected: 11
    println("--------------------")

    // --- Verification of Output ---
    println("\n--- Summary of Outputs ---")
    // This corresponds to the list of outputs in the problem description [null, 8, null, 2, 1, null, null, 11]
    println("Output for count(7): $count1")
    println("Output for count(8): $count2")
    println("Output for count(4): $count3")
    println("Output for count(7): $count4")
}