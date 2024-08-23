# Solution Explain


This code solves the problem of counting the number of islands in a grid. An island is defined as a group of connected '1's (representing land) surrounded by '0's (representing water). The connections are only horizontal and vertical, not diagonal. Here’s a step-by-step explanation of the code:

1. **`getAdjNeighbors(i, j, grid, visited)` Function:**

   - This function returns the adjacent (neighboring) cells of a given cell `(i, j)` that have not been visited yet.
   - It checks each direction (up, down, left, right) and adds the valid (within grid bounds and not visited) neighbors to the `adjNeighbors` array.
2. **`dfs(i, j, grid, visited)` Function:**

   - This function performs a depth-first search (DFS) to explore all connected land cells starting from the cell `(i, j)`.
   - It uses a stack to keep track of cells to explore.
   - As it explores, it marks cells as visited to avoid reprocessing and counts the size of the island.
   - If an island is detected (i.e., any '1' is found), the function returns `true`; otherwise, it returns `false`.
3. **`numIslands(grid)` Function:**

   - This function initializes a `visited` matrix of the same size as `grid` to keep track of which cells have been processed.
   - It iterates through each cell in the `grid`. For each cell that is part of an island and hasn’t been visited yet, it invokes the `dfs` function to explore the entire island.
   - If `dfs` returns `true`, it means a new island has been found, and the `islandCount` is incremented.
4. **Usage and Output:**

   - The `numIslands` function is called with a predefined `grid`, and it prints the number of islands detected. In this example, the output is `1` because there is only one island in the given grid.

In summary, the code counts the number of distinct islands in a grid using depth-first search to explore and mark all connected land cells.
