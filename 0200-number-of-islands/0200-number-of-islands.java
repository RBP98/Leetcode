class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    private void bfs(int currRow, int currCol, char[][] grid, boolean[][] visited, int rows, int cols){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(currRow,currCol));
        visited[currRow][currCol] = true;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int first = p.first;
            int second  = p.second;
            int[] drow = {0, 1, 0, -1};
            int[] dcol = {1, 0, -1, 0};
            for(int i = 0; i < 4; i++){
                int nrow = first + drow[i];
                int ncol = second + dcol[i];

                if(nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && !visited[nrow][ncol] && grid[nrow][ncol] == '1'){
                    queue.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = true;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(i, j, grid, visited, m, n);
                    count++;
                }
            }
        }
    return count;
    }
}