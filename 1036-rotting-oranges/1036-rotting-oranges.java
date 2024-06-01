// import java.util.*;

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int freshCount = 0;
        
        // Adding all rotten oranges to the queue initially and counting fresh oranges.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;  // No fresh orange present initially.

        int minutes = 0;
        int[] drow = {0, 1, 0, -1};
        int[] dcol = {1, 0, -1, 0};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {  // Process each level (minute).
                Pair temp = queue.poll();
                
                for (int i = 0; i < 4; i++) {
                    int nrow = temp.first + drow[i];
                    int ncol = temp.second + dcol[i];

                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !visited[nrow][ncol] && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;  // Rot the orange.
                        visited[nrow][ncol] = true;
                        queue.add(new Pair(nrow, ncol));
                        freshCount--;  // Decrease count of fresh oranges.
                    }
                }
            }
            minutes++;
        }

        // Check if there are still fresh oranges left.
        return freshCount == 0 ? minutes - 1 : -1;
    }
}
