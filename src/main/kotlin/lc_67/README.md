# 67. Add Binary

## Description
Given two binary strings a and b, return their sum as a binary string.

Example 1:

    Input: a = "11", b = "1"
    Output: "100"

Example 2:

    Input: a = "1010", b = "1011"
    Output: "10101"


Constraints:

* 1 <= a.length, b.length <= 104
* a and b consist only of '0' or '1' characters.
* Each string does not contain leading zeros except for the zero itself.

## Solution

Use simple add operation bit by bit.

```kotlin
class Solution {
    fun addBinary(a: String, b: String): String {
        var carry = 0
        val result = StringBuilder()
        var aIndex = a.length - 1
        var bIndex = b.length - 1
        while (carry != 0 || bIndex >= 0 || aIndex >= 0) {
            val sum = (if (aIndex >= 0) a[aIndex--] - '0' else 0) +
                    (if (bIndex >= 0) b[bIndex--] - '0' else 0) +
                    carry

            result.append(sum % 2)
            carry = sum / 2
        }

        return result.reverse().toString()
    }
}
```
