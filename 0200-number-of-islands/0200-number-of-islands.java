class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    private void bfs(char[][] grid, boolean[][] visited, int row, int col, int m, int n){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row][col] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int first = p.first;
            int second = p.second;

            int[] rows = {0, -1, 0, 1};
            int[] cols = {1, 0, -1, 0};

            for(int i = 0; i < 4; i++){
                int nrow = first + rows[i];
                int ncol = second + cols[i];

                if(nrow < m && ncol < n && nrow >= 0 && ncol >= 0 && !visited[nrow][ncol] && grid[nrow][ncol] == '1'){
                    queue.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = true;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid, visited, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, boolean[][] visited, int row, int col, int m, int n){
        if(row >= m || col >= n || row < 0 || col < 0  || visited[row][col] || grid[row][col] == '0' ) return;
        visited[row][col] = true;
        dfs(grid, visited, row, col + 1, m, n);
        dfs(grid, visited, row - 1, col, m, n);
        dfs(grid, visited, row, col - 1, m, n);
        dfs(grid, visited, row + 1, col, m, n);
    }
}