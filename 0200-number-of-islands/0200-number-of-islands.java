class Solution {
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