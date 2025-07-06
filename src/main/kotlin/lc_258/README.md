# 268. Add Digits
## Description
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:

    Input: num = 38
    Output: 2
    Explanation: The process is
    38 --> 3 + 8 --> 11
    11 --> 1 + 1 --> 2
    Since 2 has only one digit, return it.

Example 2:

    Input: num = 0
    Output: 0


Constraints:

0 <= num <= 231 - 1

Follow up: Could you do it without any loop/recursion in O(1) runtime?

## Solution

**Hints:**
- What are all the possible results? 1 -> 9
- How do they occur, periodically or randomly?
- You may find this [Wikipedia](https://en.wikipedia.org/wiki/Digital_root) article useful.

```kotlin
class Solution {
    fun addDigits(num: Int): Int {
        // 38 -> 3 + 8 -> 11 -> 2
        // 22 -> 2 + 2 -> 4
        // 158 -> 1 + 5 + 8 -> 14 -> 6

        // 0  1  2  3  4  5  6  7  8  9
        //    10 11 12 13 14 15 15 17 18 
        //    19
        
        // if (num <= 9) return num % 10

        // if (num % 9 == 0) {
        //     return 9
        // }

        // return (num) % 9

        return ((num - 1) % 9) + 1
    }
}
```