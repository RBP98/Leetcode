class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    private void bfs(int row, int col, boolean[][] visited, char[][] grid, int m, int n){
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(row, col));
        visited[row][col] = true;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int first = p.first;
            int second = p.second;

            int drow[] = {0, 1, 0, -1};
            int dcol[] = {1, 0, -1, 0};

            for(int i = 0; i < 4; i++){
                int nrow = drow[i] + first;
                int ncol = dcol[i] + second;

                if(nrow >=0 && nrow < m && ncol >= 0 && ncol < n && !visited[nrow][ncol] && grid[nrow][ncol] == '1'){
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
        int count = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(i, j, visited, grid, m, n);
                    count++;
                }
            }
        }
        return count;
    }
}