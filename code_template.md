Two pointers: one input, opposite ends

```python3
def fn(arr):
    left = ans = 0
    right = len(arr) - 1

    while left < right:
        # do some logic here with left and right
        if CONDITION:
            left += 1
        else:
            right -= 1
    
    return ans
```

```javascript
let fn = arr => {
    let left = 0, ans = 0, right = arr.length - 1;

    while (left < right) {
        // do some logic here with left and right
        if (CONDITION) {
            left++;
        } else {
            right--;
        }
    }

    return ans;
}
```

Two pointers: two inputs, exhaust both

```python
def fn(arr1, arr2):
    i = j = ans = 0

    while i < len(arr1) and j < len(arr2):
        # do some logic here
        if CONDITION:
            i += 1
        else:
            j += 1
    
    while i < len(arr1):
        # do logic
        i += 1
    
    while j < len(arr2):
        # do logic
        j += 1
    
    return ans
```

```javascript
let fn = (arr1, arr2) => {
    let i = 0, j = 0, ans = 0;
    
    while (i < arr1.length && j < arr2.length) {
        // do some logic here
        if (CONDITION) {
            i++;
        } else {
            j++;
        }
    }

    while (i < arr1.length) {
        // do logic
        i++;
    }

    while (j < arr2.length) {
        // do logic
        j++;
    }

    return ans;
}
```

Sliding window

```python3
def fn(arr):
    left = ans = curr = 0

    for right in range(len(arr)):
        # do logic here to add arr[right] to curr

        while WINDOW_CONDITION_BROKEN:
            # remove arr[left] from curr
            left += 1

        # update ans
    
    return ans
```

```javascript
let fn = arr => {
    let left = 0, ans = 0, curr = 0;

    for (let right = 0; right < arr.length; right++) {
        // do logic here to add arr[right] to curr

        while (WINDOW_CONDITION_BROKEN) {
            // remove arr[left] from curr
            left++;
        }

        // update ans
    }

    return ans;
}
```

Build a prefix sum

```python3
def fn(arr):
    prefix = [arr[0]]
    for i in range(1, len(arr)):
        prefix.append(prefix[-1] + arr[i])
    
    return prefix
```

```javascript
let fn = arr => {
    let prefix = [arr[0]];
    for (let i = 1; i < arr.length; i++) {
        prefix.push(prefix[prefix.length - 1] + arr[i]);
    }

    return prefix;
}
```

Efficient string building

```python3
# arr is a list of characters
def fn(arr):
    ans = []
    for c in arr:
        ans.append(c)
    
    return "".join(ans)
```

```javascript
// arr is a list of characters
let fn = arr => {
    let ans = [];
    for (const c of arr) {
        ans.push(c);
    }

    return ans.join("")
}

let fn = arr => {
    let ans = "";
    for (const c of arr) {
        ans += c;
    }

    return ans;
}
```

> In JavaScript, benchmarking shows that concatenation with += is faster than using .join().

Linked list: fast and slow pointer

```python3
def fn(head):
    slow = head
    fast = head
    ans = 0

    while fast and fast.next:
        # do logic
        slow = slow.next
        fast = fast.next.next
    
    return ans
```

```javascript
let fn = head => {
    let slow = head;
    let fast = head;
    let ans = 0;
    
    while (fast && fast.next) {
        // do logic
        slow = slow.next;
        fast = fast.next.next;
    }
    
    return ans;
}
```

Reversing a linked list

```python3
def fn(head):
    curr = head
    prev = None
    while curr:
        next_node = curr.next
        curr.next = prev
        prev = curr
        curr = next_node 
        
    return prev
```

```javascript
let fn = head => {
    let curr = head;
    let prev = null;
    while (curr) {
        let nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
    }

    return prev;
}
```

Find number of subarrays that fit an exact criteria

```python3
from collections import defaultdict

def fn(arr, k):
    counts = defaultdict(int)
    counts[0] = 1
    ans = curr = 0

    for num in arr:
        # do logic to change curr
        ans += counts[curr - k]
        counts[curr] += 1
    
    return ans
```

```javascript
let fn = (arr, k) => {
    let counts = new Map();
    counts.set(0, 1);
    let ans = 0, curr = 0;

    for (const num of arr) {
        // do logic to change curr
        ans += counts.get(curr - k) || 0;
        counts.set(curr, (counts.get(curr) || 0) + 1);
    }

    return ans;
}
```

Monotonic increasing stack

The same logic can be applied to maintain a monotonic queue.

```python3
def fn(arr):
    stack = []
    ans = 0

    for num in arr:
        # for monotonic decreasing, just flip the > to <
        while stack and stack[-1] > num:
            # do logic
            stack.pop()
        stack.append(num)
    
    return ans
```

```javascript
let fn = arr => {
    let stack = [];
    let ans = 0;

    for (const num of arr) {
        // for monotonic decreasing, just flip the > to <
        while (stack.length && stack[stack.length - 1] > num) {
            // do logic
            stack.pop();
        }

        stack.push(num);
    }

    return ans;
}
```

Binary tree: DFS (recursive)

```python3
def dfs(root):
    if not root:
        return
    
    ans = 0

    # do logic
    dfs(root.left)
    dfs(root.right)
    return ans
```

```javascript
let dfs = root => {
    if (!root) {
        return;
    }

    let ans = 0;

    // do logic
    dfs(root.left);
    dfs(root.right);
    return ans;
}
```

Binary tree: DFS (iterative)

```python3
def dfs(root):
    stack = [root]
    ans = 0

    while stack:
        node = stack.pop()
        # do logic
        if node.left:
            stack.append(node.left)
        if node.right:
            stack.append(node.right)

    return ans
```

```javascript
let dfs = root => {
    let stack = [root];
    let ans = 0;

    while (stack.length) {
        let node = stack.pop();
        // do logic
        if (node.left) {
            stack.push(node.left);
        }
        if (node.right) {
            stack.push(node.right);
        }
    }

    return ans;
}
```

Binary tree: BFS

```python3
from collections import deque

def fn(root):
    queue = deque([root])
    ans = 0

    while queue:
        current_length = len(queue)
        # do logic for current level

        for _ in range(current_length):
            node = queue.popleft()
            # do logic
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)

    return ans
```

```javascript
let fn = root => {
    let queue = [root];
    let ans = 0;

    while (queue.length) {
        let currentLength = queue.length;
        // do logic for current level

        let nextQueue = [];

        for (let i = 0; i < currentLength; i++) {
            let node = queue[i];
            // do logic
            if (node.left) {
                nextQueue.push(node.left);
            }
            if (node.right) {
                nextQueue.push(node.right);
            }
        }

        queue = nextQueue;
    }

    return ans;
}
```

Graph: DFS (recursive)

For the graph templates, assume the nodes are numbered from 0 to n - 1 and the graph is given as an adjacency list. Depending on the problem, you may need to convert the input into an equivalent adjacency list before using the templates.

```python3
def fn(graph):
    def dfs(node):
        ans = 0
        # do some logic
        for neighbor in graph[node]:
            if neighbor not in seen:
                seen.add(neighbor)
                ans += dfs(neighbor)
        
        return ans

    seen = {START_NODE}
    return dfs(START_NODE)
```

```javascript
let fn = graph => {
    let dfs = node => {
        let ans = 0;
        // do some logic
        for (const neighbor of graph[node]) {
            if (!seen.has(neighbor)) {
                seen.add(neighbor);
                ans += dfs(neighbor);
            }
        }

        return ans;
    }

    let seen = new Set([START_NODE]);
    return dfs(START_NODE);
}
```

Graph: DFS (iterative)

```python3
def fn(graph):
    stack = [START_NODE]
    seen = {START_NODE}
    ans = 0

    while stack:
        node = stack.pop()
        # do some logic
        for neighbor in graph[node]:
            if neighbor not in seen:
                seen.add(neighbor)
                stack.append(neighbor)
    
    return ans
```

```javascript
let fn = graph => {
    let stack = [START_NODE];
    let seen = new Set([START_NODE]);
    let ans = 0;

    while (stack.length) {
        let node = stack.pop();
        // do some logic
        for (const neighbor of graph[node]) {
            if (!seen.has(neighbor)) {
                seen.add(neighbor);
                stack.push(neighbor);
            }
        }
    }

    return ans;
}
```

```python3
from collections import deque

def fn(graph):
    queue = deque([START_NODE])
    seen = {START_NODE}
    ans = 0

    while queue:
        node = queue.popleft()
        # do some logic
        for neighbor in graph[node]:
            if neighbor not in seen:
                seen.add(neighbor)
                queue.append(neighbor)
    
    return ans
```

```javascript
let fn = graph => {
    let queue = [START_NODE];
    let seen = new Set([START_NODE]);
    let ans = 0;

    while (queue.length) {
        let currentLength = 0;
        let nextQueue = [];

        for (let i = 0; i < currentLength; i++) {
            let node = queue[i];
            // do some logic
            for (const neighbor of graph[node]) {
                if (!seen.has(neighbor)) {
                    seen.add(neighbor);
                    nextQueue.push(neighbor);
                }
            }
        }

        queue = nextQueue;
    }

    return ans;
}
```

Find top k elements with heap

```python
import heapq

def fn(arr, k):
    heap = []
    for num in arr:
        # do some logic to push onto heap according to problem's criteria
        heapq.heappush(heap, (CRITERIA, num))
        if len(heap) > k:
            heapq.heappop(heap)
    
    return [num for num in heap]
```

```javascript
/*
JavaScript does not have any built in support - it is recommended
that you have another language ready in case you need to use a heap
*/
```

soy

Binary search

```python3
def fn(arr, target):
    left = 0
    right = len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            # do something
            return
        if arr[mid] > target:
            right = mid - 1
        else:
            left = mid + 1
    
    # left is the insertion point
    return left
```

```javascript
let fn = (arr, target) => {
    let left = 0;
    let right = arr.length - 1;
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        if (arr[mid] == target) {
            // do something
            return;
        }
        if (arr[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    // left is the insertion point
    return left;
}
```

Binary search: duplicate elements, left-most insertion point

```python
def fn(arr, target):
    left = 0
    right = len(arr)
    while left < right:
        mid = (left + right) // 2
        if arr[mid] >= target:
            right = mid
        else:
            left = mid + 1

    return left
```

```javascript
let fn = (arr, target) => {
    let left = 0;
    let right = arr.length;
    while (left < right) {
        let mid = Math.floor((left + right) / 2);
        if (arr[mid] >= target) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }

    return left;
}
```

Binary search: duplicate elements, right-most insertion point

```python
def fn(arr, target):
    left = 0
    right = len(arr)
    while left < right:
        mid = (left + right) // 2
        if arr[mid] > target:
            right = mid
        else:
            left = mid + 1

    return left
```

```javascript
let fn = (arr, target) => {
    let left = 0;
    let right = arr.length;
    while (left < right) {
        let mid = Math.floor((left + right) / 2);
        if (arr[mid] > target) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }

    return left;
}
```

Binary search: for greedy problems

If looking for a minimum:

```python
def fn(arr):
    def check(x):
        # this function is implemented depending on the problem
        return BOOLEAN

    left = MINIMUM_POSSIBLE_ANSWER
    right = MAXIMUM_POSSIBLE_ANSWER
    while left <= right:
        mid = (left + right) // 2
        if check(mid):
            right = mid - 1
        else:
            left = mid + 1
    
    return left
```

```javascript
let fn = arr => {
    let check = x => {
        // this function is implemented depending on the problem
        return BOOLEAN;
    }

    let left = MINIMUM_POSSIBLE_ANSWER;
    let right = MAXMIMUM_POSSIBLE_ANSWER;
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        if (check(mid)) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return left;
}
```

If looking for a maximum:

```python
def fn(arr):
    def check(x):
        # this function is implemented depending on the problem
        return BOOLEAN

    left = MINIMUM_POSSIBLE_ANSWER
    right = MAXIMUM_POSSIBLE_ANSWER
    while left <= right:
        mid = (left + right) // 2
        if check(mid):
            left = mid + 1
        else:
            right = mid - 1
    
    return right
```

```javascript
let fn = arr => {
    let check = x => {
        // this function is implemented depending on the problem
        return BOOLEAN;
    }

    let left = MINIMUM_POSSIBLE_ANSWER;
    let right = MAXMIMUM_POSSIBLE_ANSWER;
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        if (check(mid)) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return right;
}
```

Backtracking

```python
def backtrack(curr, OTHER_ARGUMENTS...):
    if (BASE_CASE):
        # modify the answer
        return
    
    ans = 0
    for (ITERATE_OVER_INPUT):
        # modify the current state
        ans += backtrack(curr, OTHER_ARGUMENTS...)
        # undo the modification of the current state
    
    return ans
```

```javascript
let backtrack = (curr, OTHER_ARGUMENTS...) => {
    if (BASE_CASE) {
        // modify the answer
        return;
    }

    let ans = 0;
    for (ITERATE_OVER_INPUT) {
        // modify the current state
        ans += backtrack(curr, OTHER_ARGUMENTS...);
        // undo the modification of the current state
    }

    return ans;
}
```

Dynamic programming: top-down memoization

```python
def fn(arr):
    def dp(STATE):
        if BASE_CASE:
            return 0
        
        if STATE in memo:
            return memo[STATE]
        
        ans = RECURRENCE_RELATION(STATE)
        memo[STATE] = ans
        return ans

    memo = {}
    return dp(STATE_FOR_WHOLE_INPUT)
```

```javascript
let fn = arr => {
    let dp = STATE => {
        if (BASE_CASE) {
            return 0;
        }

        if (memo[STATE] != -1) {
            return memo[STATE];
        }

        let ans = RECURRENCE_RELATION(STATE);
        memo[STATE] = ans;
        return ans;
    }

    let memo = ARRAY_SIZED_ACCORDING_TO_STATE;
    return dp(STATE_FOR_WHOLE_INPUT);
}
```

Build a trie

```python3
# note: using a class is only necessary if you want to store data at each node.
# otherwise, you can implement a trie using only hash maps.
class TrieNode:
    def __init__(self):
        # you can store data at nodes if you wish
        self.data = None
        self.children = {}

def fn(words):
    root = TrieNode()
    for word in words:
        curr = root
        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        # at this point, you have a full word at curr
        # you can perform more logic here to give curr an attribute if you want
    
    return root
```

```javascript
// note: using a class is only necessary if you want to store data at each node.
// otherwise, you can implement a trie using only hash maps.
class TrieNode {
    constructor() {
        // you can store data at nodes if you wish
        this.data = null;
        this.children = new Map();
    }
}

let fn = words => {
    let root = new TrieNode();
    for (const word of words) {
        let curr = root;
        for (const c of word) {
            if (!curr.children.has(c)) {
                curr.children.set(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }

        // at this point, you have a full word at curr
        // you can perform more logic here to give curr an attribute if you want
    }

    return root;
}
```

















