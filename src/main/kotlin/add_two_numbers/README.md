## Problem: Add Two Numbers

### Problem Description

You are given two **non-negative numbers** represented as **linked lists**. Each **node** in the linked list contains a
single **digit**. The digits are stored in **reverse order**, meaning the 1's digit is at the head of the list. Your
task is to add the two numbers and return their **sum** as a new linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

### `ListNode` Structure

To work with this problem, we'll use a basic `ListNode` structure for the linked list, commonly defined as follows (
e.g., in Java or Kotlin):

```java
public class ListNode {
    int val;    // The digit's value in the node
    ListNode next; // Pointer to the next node

    ListNode(int val) {
        this.val = val;
    }
}
```

### Example

Let's look at a concrete example to better understand how numbers are represented and the sum is calculated:

* **Input:**
    * $l_1 = [2, 4, 3]$
    * $l_2 = [5, 6, 4]$

* **Number Representation Explanation:**
    * The linked list $l_1 = [2, 4, 3]$ represents the number $342$. (Since 2 is the units digit, 4 is the tens digit,
      and 3 is the hundreds digit).
    * The linked list $l_2 = [5, 6, 4]$ represents the number $465$. (Since 5 is the units digit, 6 is the tens digit,
      and 4 is the hundreds digit).

* **Actual Summation:**
  $342 + 465 = 807$

* **Expected Output:**
    * The sum $807$ will be represented as a linked list in reverse order: $[7, 0, 8]$.

### Key Considerations

* **Reverse Order:** This is a crucial detail that simplifies the problem, as we can add directly from the head of the
  lists (just like adding from the units digit by hand).
* **Carry:** Similar to manual addition, you'll need to handle the **carry** when the sum of digits exceeds 9.
* **Different Lengths:** The two linked lists might have different lengths. Your solution needs to gracefully handle the
  case where one list ends before the other.
* **Final Carry:** After iterating through both lists, if there's still a carry left over (e.g., $9 + 1 = 10$), you must
  add an additional node for this carry to the end of your result list.