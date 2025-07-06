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