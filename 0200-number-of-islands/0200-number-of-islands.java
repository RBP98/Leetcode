
class Solution {
    public void bfs(int i, int j, int m, int n, boolean[][] visited, char[][] grid){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});

        visited[i][j] = true;

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int first = node[0];
            int second = node[1];
            
            int[] drow = {0, 1, 0 ,-1};
            int[] dcol = {1, 0, -1, 0};

            for(int k = 0; k < 4; k++){
                int nrow = drow[k] + first;
                int ncol = dcol[k] + second;

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !visited[nrow][ncol] && grid[nrow][ncol] == '1'){
                    visited[nrow][ncol] = true;
                    queue.add(new int[]{nrow, ncol});
                }

            }

        }
    }
    public int numIslands(char[][] grid) {
        int m  = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];
        int count = 0;
        for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(i, j, m, n, visited, grid);
                    count++;
                }
                
            }
        }

        return count;

    }
}