# Intuition

The hints tols us to sort the array.

When sorted, if `nums[left]` is our chosen minimum (fixed).

Then, the maximum number can be between `nums[left + 1]` and `nums[right]`.

So our goal is compute **how many subsequences from `left + 1` to `right`**, in the other words, **how many subsequences can be made from `right - left` elements**.


Therefore, we add to the count `2 ^ (right - left)` subsequences (this formual just search on Google).


# Approach


-----

# Complexity

- **Time complexity**: $O(NLogN)$
- **Space complexity**: $O(N)$


# Code
```kotlin []
class Solution {
    val mod = 1_000_000_007
    fun numSubseq(nums: IntArray, target: Int): Int {

        if (nums.isEmpty()) return 0
        val powOf2 = IntArray(nums.size) { 1 }
        for (i in 1 until nums.size) {
            powOf2[i] = powOf2[i - 1] * 2 % mod
        }

        nums.sort()
        var result = 0
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // left is fixed as a minimum.
                // the maximum can be any number between left and right.
                // => subsequences = 2 ^ (right - left). Because we just add num[left] in each subsequence, we exclude left.
                result = (result + powOf2[right - left]) % mod
                // now increase left.
                left++
            } else {
                right--
            }
        }

        return result
    }
}
```