class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    private void bfs(int m, int n, int row, int col, char[][] grid, boolean[][] visited){
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(row, col));
        visited[row][col] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int first = p.first;
            int second = p.second;
            
            int[] drow = {0, 1, 0, -1};
            int[] dcol = {1, 0 ,-1, 0};

            for(int i = 0; i < 4; i++){
                int nrow = first + drow[i];
                int ncol = second + dcol[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == '1' && !visited[nrow][ncol]){
                    visited[nrow][ncol] = true;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(m, n, i, j, grid, visited);
                    count++;
                }
            }
        } 
        return count;
    }
}