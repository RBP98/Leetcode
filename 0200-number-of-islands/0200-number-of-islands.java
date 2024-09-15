class Solution {
    private void bfs(char[][] grid, boolean[][] visited, int row, int col, int m, int n){
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(row, col));
        visited[row][col] = true;
        
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int first = p.first;
            int second = p.second;

            int[] drow = {0, 1, 0, -1};
            int[] dcol = {1, 0, -1, 0};

            for(int i = 0; i < 4; i++){
                int nrow = first + drow[i];
                int ncol = second + dcol[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !visited[nrow][ncol] && grid[nrow][ncol] == '1'){
                    visited[nrow][ncol] = true;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        } 
    }


    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count  = 0;
        for(int i =0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(grid, visited, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }
}

class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }