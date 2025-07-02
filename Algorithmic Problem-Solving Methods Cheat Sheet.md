# Algorithmic Problem-Solving Methods Cheat Sheet

## 🔥 Core Approaches

### **Brute Force**

* Try all possible solutions
* Simple to implement but often inefficient
* Good starting point to understand the problem
* **Time:** Usually O(n!) or O(2^n)
* **Use when:** Small input size, need correctness first

### **Greedy Algorithm**

* Make locally optimal choice at each step
* Hope global optimum is achieved
* **Examples:** Activity selection, coin change (specific cases)
* **Time:** Usually O(n log n) or O(n)

### **Divide and Conquer**

* Break problem into smaller subproblems
* Solve recursively and combine results
* **Examples:** Merge sort, quick sort, binary search
* **Time:** Often O(n log n)

## 🧠 Dynamic Programming Patterns

### **Top-Down (Memoization)**

* Recursive approach with caching
* Start from original problem, break down
* **Pattern:**`memo[state] = solve(state)`

### **Bottom-Up (Tabulation)**

* Iterative approach building up solutions
* Start from base cases, build up
* **Pattern:** Fill DP table from smaller to larger subproblems

### **Common DP Types:**

* **1D DP:**`dp[i]` represents solution for first i elements
* **2D DP:**`dp[i][j]` for problems with two dimensions
* **State Machine DP:** Track different states (buy/sell stocks)

## 🔍 Search Techniques

### **Depth-First Search (DFS)**

* Explore as far as possible before backtracking
* **Space:** O(depth)
* **Use:** Tree traversal, connected components, topological sort

### **Breadth-First Search (BFS)**

* Explore level by level
* **Space:** O(width)
* **Use:** Shortest path in unweighted graph, level-order traversal

### **Binary Search**

* Divide search space in half each iteration
* **Time:** O(log n)
* **Variants:** Find exact, find first/last occurrence, find insertion point

### **Backtracking**

* Try all possibilities, undo when path doesn't work
* **Pattern:** Choose → Explore → Unchoose
* **Examples:** N-Queens, permutations, combinations

## 📊 Data Structure Strategies

### **Two Pointers**

* **Same Direction:** Fast/slow pointer (cycle detection)
* **Opposite Direction:** Left/right for sorted arrays
* **Time:** O(n), **Space:** O(1)

### **Sliding Window**

* **Fixed Size:** Move window of constant size
* **Variable Size:** Expand/contract based on condition
* **Examples:** Max sum subarray, longest substring

### **Hash Map/Set**

* **Frequency Counting:** Track occurrences
* **Lookup:** O(1) average time for existence checks
* **Two Sum Pattern:** Store complement values

### **Stack**

* **Monotonic Stack:** Maintain increasing/decreasing order
* **Expression Evaluation:** Handle parentheses and operators
* **Examples:** Next greater element, valid parentheses

### **Queue**

* **BFS:** Level-order processing
* **Deque:** Operations at both ends
* **Priority Queue/Heap:** Always access min/max element

## 🌳 Tree Algorithms

### **Tree Traversals**

* **Inorder:** Left → Root → Right
* **Preorder:** Root → Left → Right
* **Postorder:** Left → Right → Root
* **Level-order:** BFS approach

### **Tree Patterns**

* **Path Sum:** DFS with running sum
* **Lowest Common Ancestor:** Bottom-up or binary lifting
* **Tree Diameter:** DFS from any node, then from farthest node

## 📈 Graph Algorithms

### **Shortest Path**

* **Dijkstra:** Single source, non-negative weights
* **Bellman-Ford:** Single source, handles negative weights
* **Floyd-Warshall:** All pairs shortest path

### **Minimum Spanning Tree**

* **Kruskal:** Sort edges, use Union-Find
* **Prim:** Grow tree from starting vertex

### **Topological Sort**

* **Kahn's Algorithm:** Remove vertices with no incoming edges
* **DFS-based:** Post-order of DFS gives reverse topological order

## 🔧 Advanced Techniques

### **Union-Find (Disjoint Set)**

* **Operations:** Find with path compression, Union by rank
* **Use:** Connected components, cycle detection
* **Time:** Nearly O(1) amortized

### **Trie (Prefix Tree)**

* **Operations:** Insert, search, prefix matching
* **Use:** Word search, autocomplete, IP routing

### **Segment Tree / Fenwick Tree**

* **Range Queries:** Sum, min, max over range
* **Point Updates:** Modify single element
* **Time:** O(log n) for both operations

### **Bit Manipulation**

* **XOR Properties:** a^a=0, a^0=a, commutative
* **Common Tricks:** Check if power of 2: `n&(n-1)==0`
* **Bit Masks:** Represent subsets as integers

## 📝 Problem-Solving Patterns

### **Iteration Patterns**

* **One Pass:** Single iteration through data
* **Two Pass:** First pass for preprocessing, second for main logic
* **Multiple Passes:** Each pass handles different aspect

### **State Management**

* **Finite State Machine:** Limited states with transitions
* **State Compression:** Use bits to represent multiple states
* **Rolling Array:** Optimize space in DP by keeping only necessary states

### **Mathematical Approaches**

* **Modular Arithmetic:** Handle large numbers
* **Fast Exponentiation:** Compute a^b in O(log b)
* **GCD/LCM:** Euclidean algorithm
* **Prime Factorization:** Trial division, sieve methods

## 🎯 Time/Space Optimization

### **Space Optimization**

* **In-place Algorithms:** Modify input array directly
* **Rolling Variables:** Keep only necessary previous values
* **Bit Packing:** Store multiple values in single integer

### **Time Optimization**

* **Preprocessing:** Calculate expensive operations once
* **Caching/Memoization:** Store computed results
* **Early Termination:** Stop when answer is found
* **Skip Redundant Work:** Avoid recalculating same values

## 🚀 Quick Decision Framework

1. **Identify Pattern:** What type of problem is this?
2. **Constraints:** What are the time/space requirements?
3. **Data Structure:** What structure best fits the access pattern?
4. **Algorithm:** Which approach matches the pattern?
5. **Optimize:** Can we improve time/space complexity?

## 💡 Common Problem Types → Solutions

* **Array/String:** Two pointers, sliding window, hash map
* **Tree/Graph:** DFS, BFS, dynamic programming on trees
* **Optimization:** Dynamic programming, greedy
* **Counting:** Hash map, mathematical formulas
* **Searching:** Binary search, DFS/BFS
* **Sorting:** Merge sort, quick sort, counting sort
* **Intervals:** Sort by start/end time, sweep line
* **Subsequence:** Dynamic programming, greedy
