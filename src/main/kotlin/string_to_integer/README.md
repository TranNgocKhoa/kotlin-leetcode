## AtoI Problem: String to Integer (atoi)

**Problem Description:**

Implement the `atoi` function, which converts a string to a 32-bit signed integer (similar to C/C++'s `atoi` function).

The function typically needs to handle the following scenarios:

1. **Whitespace:** Discard leading whitespace characters until the first non-whitespace character is found.

2. **Sign:** Check for an optional leading `+` or `-` sign. If a sign is present, it determines the sign of the final
   integer. If no sign is present, the number is considered positive.

3. **Digits:** Read as many numerical digits as possible until a non-digit character or the end of the string is
   encountered. These digits form the numerical value.

4. **Invalid Input:** If the first non-whitespace character is not a digit, a `+`, or a `-`, then no valid conversion
   can be performed, and the function should return `0`.

5. **Overflow:** The converted integer must be within the range of a 32-bit signed integer, which is
   `[-2^31, 2^31 - 1]`.
    * If the integer overflows (is greater than `2^31 - 1`), return `2^31 - 1`.
    * If the integer underflows (is less than `-2^31`), return `-2^31`.

6. **Remaining Characters:** Any characters after the valid integer portion should be ignored.

**Examples:**

* `"42"` -> `42`
* `"   -42"` -> `-42` (Leading spaces are ignored, then a negative sign is processed)
* `"4193 with words"` -> `4193` (Conversion stops at 'w')
* `"words and 987"` -> `0` (First non-whitespace character is 'w', which is not a valid start)
* `"-91283472332"` -> `-2147483648` (Underflow, clamped to `Integer.MIN_VALUE`)
* `"2147483647"` -> `2147483647` (Max value, no overflow)
* `"2147483648"` -> `2147483647` (Overflow, clamped to `Integer.MAX_VALUE`)

**Constraints/Considerations for Implementation:**

* **Integer Limits:** Be mindful of `Integer.MAX_VALUE` ($2^{31} - 1$) and `Integer.MIN_VALUE` ($-2^{31}$). You'll need
  to check for potential overflows *before* the current result exceeds these limits during the digit processing.
* **Edge Cases:** Empty string, string with only whitespace, string with only a sign, strings with leading zeros, etc.
* **Character Handling:** Efficiently check if a character is a digit, whitespace, or a sign.