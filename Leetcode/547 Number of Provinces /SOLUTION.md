# Solution Explain


This code is designed to find the number of connected components (or "provinces") in an undirected graph represented by an adjacency matrix. In the context of the problem, each element in the matrix indicates whether two cities are directly connected. Each connected component represents a group of cities that are interconnected, either directly or indirectly.

Here's a detailed explanation of each part of the code:

### 1. `getEdgs` Function

```javascript
const getEdgs = (idx, edge) => {
    const edges = [];
    for (let i = 0; i < edge.length; i++) {
        if (idx === i) continue;
        if (edge[i] === 0) continue;
        edges.push(i);
    }
    return edges;
}
```

- **Purpose:** This function returns the list of adjacent nodes (neighbors) for a given node `idx` based on the `edge` array.
- **Parameters:**
  - `idx`: The index of the current node.
  - `edge`: An array representing the connections of the current node.
- **Logic:**
  - It iterates through the `edge` array.
  - It skips the current node (`idx`).
  - It adds node indices to `edges` if there is a connection (`edge[i] !== 0`).
- **Returns:** An array of adjacent nodes for the given node `idx`.

### 2. `buildAdjList` Function

```javascript
const buildAdjList = (edges, n = edges.length) => {
    const adjList = Array.from({ length: n }, () => []);
    for (let i = 0; i < adjList.length; i++) {
        adjList[i].push(...getEdgs(i, edges[i]));
    }
    return adjList;
}
```

- **Purpose:** Converts the adjacency matrix into an adjacency list representation.
- **Parameters:**
  - `edges`: The adjacency matrix.
  - `n`: Number of nodes (optional, defaults to the length of `edges`).
- **Logic:**
  - Creates an empty adjacency list with `n` empty arrays.
  - Fills each entry in `adjList` using the `getEdgs` function.
- **Returns:** The adjacency list representing the graph.

### 3. `dfs` Function

```javascript
const dfs = (node, adjList, visited) => {
    visited[node] = true;
    for (let neighbor of adjList[node]) {
        if (!visited[neighbor]) {
            visited[neighbor] = true;
            dfs(neighbor, adjList, visited);
        }
    }
}
```

- **Purpose:** Performs a depth-first search (DFS) to traverse the graph and mark all nodes in the same connected component.
- **Parameters:**
  - `node`: The starting node for DFS.
  - `adjList`: The adjacency list representing the graph.
  - `visited`: An object tracking visited nodes.
- **Logic:**
  - Marks the current `node` as visited.
  - Recursively visits all unvisited neighbors of the current node.
- **Effect:** Ensures all nodes connected to `node` are marked as visited.

### 4. `findCircleNum` Function

```javascript
const findCircleNum = (isConnected) => {
    const adjList = buildAdjList(isConnected);
    const visited = {};
    let provinces = 0;
    for (let vertex = 0; vertex < adjList.length; vertex++) {
        if (!visited[vertex]) {
            provinces++;
            dfs(vertex, adjList, visited);
        }
    }
    return provinces;
};
```

- **Purpose:** Finds the number of connected components (provinces) in the graph.
- **Parameters:**
  - `isConnected`: The adjacency matrix of the graph.
- **Logic:**
  - Builds the adjacency list from the matrix.
  - Initializes a `visited` object and a `provinces` counter.
  - Iterates through each vertex. If a vertex is not visited, it means a new connected component (province) is found.
  - Runs `dfs` starting from that vertex to mark all reachable nodes.
  - Increments the `provinces` counter for each new connected component found.
- **Returns:** The total number of provinces (connected components).

### Example

For the input `[[1, 1, 0], [1, 1, 0], [0, 0, 1]]`:

- The adjacency matrix represents 3 cities where:
  - City 0 is connected to City 1.
  - City 1 is connected to City 0.
  - City 2 is only connected to itself.

The graph has two connected components (provinces):

1. Cities 0 and 1 are connected.
2. City 2 is isolated.

Thus, the output `findCircleNum([[1, 1, 0], [1, 1, 0], [0, 0, 1]])` is `2`.
