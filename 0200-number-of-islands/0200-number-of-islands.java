class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(grid, visited, i, j, m, n);
                    count++;
                }
            }
        } 
        return count;
    }

    private void bfs(char[][] grid, boolean[][] visited, int row, int col, int m, int n){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));

        visited[row][col] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int first = p.first;
            int second = p.second;

            int[] drow = {0, 1, 0, -1};
            int[] dcol = {1, 0 ,-1 ,0};

            for(int i = 0; i < 4; i++){
                int nrow = p.first + drow[i];
                int ncol = p.second + dcol[i];

                if(0 <= nrow && nrow < m && 0 <= ncol && ncol < n && grid[nrow][ncol] == '1' && !visited[nrow][ncol]){
                    queue.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = true;
                }
            }
        } 
    }
}