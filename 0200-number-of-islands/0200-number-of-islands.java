class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {

    private void bfs(char[][] grid, int row, int col, boolean[][] visited, int n, int m){
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(row, col));
        visited[row][col] = true;

        int[] drow = {0,1,0,-1};
        int[] dcol = {1,0,-1,0};

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int first = p.first;
            int second = p.second;

            for(int i = 0; i < 4; i++){
                int nrow = first + drow[i];
                int ncol = second + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] && grid[nrow][ncol] == '1'){
                    visited[nrow][ncol] = true;
                    queue.add(new Pair(nrow, ncol));
                }
            }

        }
    }
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(grid, i, j, visited, n, m);
                    count++;
                }
            }
        }
        return count;
    }
}