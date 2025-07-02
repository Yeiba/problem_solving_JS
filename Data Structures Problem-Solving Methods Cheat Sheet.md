# Data Structures Problem-Solving Methods Cheat Sheet

## 📋 Arrays & Strings

### **Core Operations & Complexities**

* **Access:** O(1)
* **Search:** O(n) unsorted, O(log n) sorted
* **Insert/Delete:** O(n) at arbitrary position, O(1) at end

### **Problem-Solving Patterns**

#### **Two Pointers Technique**

```
Pattern: left = 0, right = n-1
while left < right:
    if condition: move appropriate pointer
```

* **Use Cases:** Palindrome check, two sum on sorted array, remove duplicates
* **Variants:** Same direction (fast/slow), opposite direction

#### **Sliding Window**

```
Fixed Size: maintain window of size k
Variable Size: expand/shrink based on condition
```

* **Use Cases:** Max sum subarray, longest substring without repeating chars
* **Time:** O(n), **Space:** O(1) or O(k)

#### **Prefix Sum**

```
prefix[i] = prefix[i-1] + arr[i]
Range sum [i,j] = prefix[j] - prefix[i-1]
```

* **Use Cases:** Range sum queries, subarray sum problems
* **2D Prefix:** For matrix range sum queries

#### **Kadane's Algorithm**

```
max_current = max_global = arr[0]
for i in range(1, n):
    max_current = max(arr[i], max_current + arr[i])
    max_global = max(max_global, max_current)
```

* **Use Cases:** Maximum subarray sum, maximum product subarray

#### **Dutch National Flag**

```
Three-way partitioning around pivot
```

* **Use Cases:** Sort colors (0,1,2), partition around pivot

## 🔗 Linked Lists

### **Core Operations & Complexities**

* **Access:** O(n)
* **Search:** O(n)
* **Insert/Delete:** O(1) with pointer, O(n) by value

### **Problem-Solving Patterns**

#### **Two Pointers (Fast/Slow)**

```
slow = fast = head
while fast and fast.next:
    slow = slow.next
    fast = fast.next.next
```

* **Use Cases:** Find middle, detect cycle, find nth from end
* **Floyd's Cycle Detection:** Tortoise and hare

#### **Dummy Head**

```
dummy = ListNode(0)
dummy.next = head
```

* **Use Cases:** Simplify edge cases in insertion/deletion
* **When to use:** When head might change

#### **Reverse Techniques**

```
Iterative: prev, curr = None, head
Recursive: return reverse(head.next), then fix pointers
```

* **Use Cases:** Reverse list, reverse in groups, palindrome check

#### **Merge Technique**

```
Compare heads of two lists, advance smaller
```

* **Use Cases:** Merge sorted lists, merge k sorted lists

## 📚 Stacks & Queues

### **Stack Applications**

#### **Monotonic Stack**

```
Increasing: pop while stack[-1] >= current
Decreasing: pop while stack[-1] <= current
```

* **Use Cases:** Next greater element, largest rectangle in histogram
* **Pattern:** Process elements that can't be resolved immediately

#### **Expression Evaluation**

```
Operands → operand stack
Operators → operator stack (with precedence)
```

* **Use Cases:** Calculator, valid parentheses, infix to postfix

#### **Backtracking with Stack**

```
Push choices, explore, pop to backtrack
```

* **Use Cases:** Path finding, generate permutations

### **Queue Applications**

#### **BFS Pattern**

```
queue = [start]
visited = set([start])
while queue:
    node = queue.popleft()
    for neighbor in get_neighbors(node):
        if neighbor not in visited:
            queue.append(neighbor)
            visited.add(neighbor)
```

#### **Level Order Processing**

```
for level_size in range(len(queue)):
    node = queue.popleft()
    # process node
```

#### **Sliding Window Maximum (Deque)**

```
Use deque to maintain decreasing order
```

* **Pattern:** Remove elements outside window, maintain order

## 🗂️ Hash Tables (Maps/Sets)

### **Core Operations & Complexities**

* **Access/Insert/Delete:** O(1) average, O(n) worst case

### **Problem-Solving Patterns**

#### **Frequency Counting**

```
freq = {}
for item in items:
    freq[item] = freq.get(item, 0) + 1
```

* **Use Cases:** Anagrams, most frequent elements, character counts

#### **Two Sum Pattern**

```
seen = {}
for i, num in enumerate(nums):
    complement = target - num
    if complement in seen:
        return [seen[complement], i]
    seen[num] = i
```

#### **Group Anagrams Pattern**

```
groups = {}
for word in words:
    key = ''.join(sorted(word))  # or frequency count
    groups[key].append(word)
```

#### **Lookup Optimization**

```
Convert list to set for O(1) lookup
precompute = set(expensive_list)
```

## 🌳 Trees

### **Core Operations & Complexities**

* **Search/Insert/Delete:** O(log n) balanced, O(n) worst case

### **Problem-Solving Patterns**

#### **Tree Traversals**

```
Inorder: left → root → right (BST gives sorted order)
Preorder: root → left → right (copy tree)
Postorder: left → right → root (delete tree)
Level-order: BFS (level by level)
```

#### **Recursive Pattern**

```
def solve(root):
    if not root: return base_case
    left_result = solve(root.left)
    right_result = solve(root.right)
    return combine(root.val, left_result, right_result)
```

#### **Path Sum Patterns**

```
DFS with running sum
Backtrack by subtracting when returning
```

* **Variants:** Root to leaf, any path, path with target sum

#### **Lowest Common Ancestor**

```
If both nodes in different subtrees: current is LCA
Otherwise: LCA is in the subtree containing both
```

#### **Tree Diameter**

```
def diameter(root):
    def depth(node):
        if not node: return 0
        left = depth(node.left)
        right = depth(node.right)
        self.diameter = max(self.diameter, left + right)
        return max(left, right) + 1
```

#### **Serialize/Deserialize**

```
Preorder with null markers
Use queue for deserialization
```

### **Binary Search Tree Specific**

#### **Validation**

```
def isValid(root, min_val, max_val):
    if not root: return True
    if root.val <= min_val or root.val >= max_val:
        return False
    return isValid(root.left, min_val, root.val) and \
           isValid(root.right, root.val, max_val)
```

#### **Inorder Successor**

```
If right subtree exists: leftmost in right subtree
Otherwise: first ancestor where node is in left subtree
```

## 🕸️ Graphs

### **Core Representations**

* **Adjacency Matrix:** O(V²) space, O(1) edge check
* **Adjacency List:** O(V+E) space, O(degree) edge check

### **Problem-Solving Patterns**

#### **DFS Template**

```
def dfs(graph, start, visited):
    visited.add(start)
    for neighbor in graph[start]:
        if neighbor not in visited:
            dfs(graph, neighbor, visited)
```

#### **BFS Template**

```
def bfs(graph, start):
    queue = [start]
    visited = {start}
    while queue:
        node = queue.pop(0)
        for neighbor in graph[node]:
            if neighbor not in visited:
                queue.append(neighbor)
                visited.add(neighbor)
```

#### **Connected Components**

```
components = 0
visited = set()
for node in all_nodes:
    if node not in visited:
        dfs(graph, node, visited)
        components += 1
```

#### **Cycle Detection**

```
Undirected: DFS with parent tracking
Directed: DFS with three colors (white/gray/black)
```

#### **Topological Sort**

```
Kahn's Algorithm: Remove nodes with indegree 0
DFS-based: Reverse of DFS finish times
```

#### **Shortest Path**

```
Dijkstra: Priority queue with distances
Bellman-Ford: Relax all edges V-1 times
Floyd-Warshall: All pairs, DP on intermediate nodes
```

## 🔗 Union-Find (Disjoint Set)

### **Core Operations**

```python
class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [0] * n
  
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])  # Path compression
        return self.parent[x]
  
    def union(self, x, y):
        px, py = self.find(x), self.find(y)
        if px == py: return
        if self.rank[px] < self.rank[py]: px, py = py, px
        self.parent[py] = px
        if self.rank[px] == self.rank[py]: self.rank[px] += 1
```

### **Use Cases**

* Connected components in dynamic graph
* Cycle detection in undirected graph
* Minimum spanning tree (Kruskal's algorithm)

## 🌲 Trie (Prefix Tree)

### **Core Structure**

```python
class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end = False

class Trie:
    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.is_end = True
```

### **Use Cases**

* Word search problems
* Autocomplete/prefix matching
* Replace operations in multiple strings

## 🏔️ Heaps (Priority Queues)

### **Core Operations & Complexities**

* **Insert:** O(log n)
* **Extract Min/Max:** O(log n)
* **Peek:** O(1)

### **Problem-Solving Patterns**

#### **Top K Elements**

```
Use min-heap of size k for top k largest
Use max-heap of size k for top k smallest
```

#### **Merge K Sorted Lists**

```
Push first element of each list to heap
Pop min, push next element from same list
```

#### **Running Median**

```
Two heaps: max_heap (smaller half), min_heap (larger half)
Balance sizes, median is heap tops
```

#### **Dijkstra's Algorithm**

```
priority_queue = [(0, start)]
distances = {start: 0}
while priority_queue:
    dist, node = heappop(priority_queue)
    if dist > distances[node]: continue
    for neighbor, weight in graph[node]:
        new_dist = dist + weight
        if new_dist < distances.get(neighbor, float('inf')):
            distances[neighbor] = new_dist
            heappush(priority_queue, (new_dist, neighbor))
```

## 📊 Advanced Data Structures

### **Segment Tree**

* **Use Cases:** Range sum/min/max queries with updates
* **Time:** O(log n) query and update
* **Space:** O(n)

### **Fenwick Tree (Binary Indexed Tree)**

* **Use Cases:** Range sum queries with updates
* **Time:** O(log n) query and update
* **Space:** O(n)
* **Advantage:** Simpler implementation than segment tree

### **Balanced BSTs (AVL, Red-Black)**

* **Use Cases:** Maintain sorted order with efficient operations
* **Time:** O(log n) for all operations
* **Alternative:** Use built-in TreeMap/TreeSet

## 🎯 Data Structure Selection Guide

### **When to Use What?**


| Problem Type        | Best Data Structure | Alternative                  |
| ------------------- | ------------------- | ---------------------------- |
| Fast lookup         | Hash Map/Set        | Sorted Array + Binary Search |
| Maintain order      | BST                 | Sorted Array                 |
| Range queries       | Segment Tree        | Sqrt Decomposition           |
| LIFO operations     | Stack               | Array                        |
| FIFO operations     | Queue               | Array                        |
| Priority operations | Heap                | Sorted Array                 |
| Graph problems      | Adjacency List      | Adjacency Matrix             |
| String matching     | Trie                | Hash Map                     |
| Union operations    | Union-Find          | DFS/BFS                      |

### **Quick Decision Framework**

1. **What operations are most frequent?** Choose structure optimizing those
2. **What's the access pattern?** Sequential vs random vs priority
3. **Memory constraints?** Some structures have higher overhead
4. **Range operations needed?** Consider segment trees or prefix sums
5. **Ordering important?** BST vs Hash Map vs Array
