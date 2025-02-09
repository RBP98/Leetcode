class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    private int bfs(int[][] grid, boolean[][] visited, int m, int n) {
        Queue<Pair> queue = new LinkedList<>();
        int[][] directions = new int[][] { { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };


        int currDistance = 1;
        queue.add(new Pair(0, 0));

        visited[0][0] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int j = 0; j < size; j++) {
                Pair cell = queue.poll();

                int row = cell.first;
                int col = cell.second;


                if (row == m - 1 && col == n - 1)
                    return currDistance;

                for (int i = 0; i < 8; i++) {
                    int newRow = row + directions[i][0];
                    int newCol = col + directions[i][1];

                    if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && grid[newRow][newCol] == 0
                            && !visited[newRow][newCol]) {
                        queue.add(new Pair(newRow, newCol));
                        visited[newRow][newCol] = true;

                    }
                }

            }

            currDistance++;

        }

        return -1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) {

            return -1;
        }

        return bfs(grid, visited, m, n);
    }

}