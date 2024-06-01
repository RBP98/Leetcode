class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    private void bfs(int row, int col, char[][] grid, boolean[][] visited){
        Queue<Pair> queue = new LinkedList<Pair>();
        Pair p = new Pair(row, col);
        queue.add(p);
        visited[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;
        while(!queue.isEmpty()){
            int first = queue.peek().first;
            int second = queue.peek().second;
            queue.remove();
         
            int[] i = {-1, 0, 1, 0};
            int[] j = {0, 1, 0, -1};

            for(int k = 0; k < 4; k++){
                int nrow = first + i[k];
                int ncol = second + j[k];

                if(nrow >=0 && ncol >=0 && 
                    nrow < n && ncol < m 
                    // && i != Math.abs(j)
                    ){
                        if(!visited[nrow][ncol] && grid[nrow][ncol] =='1' ){
                            visited[nrow][ncol] = true;
                            queue.add(new Pair(nrow, ncol));
                        }
                        
                    }
            }
            
            // for(int i = -1; i <= 1; i++){
            //     for(int j = -1; j <= 1; j++){
            //         int nrow = first + i;
            //         int ncol = second + j;

            //         if(nrow >=0 && ncol >=0 && 
            //         nrow < n && ncol < m 
            //         && i != Math.abs(j)
            //         ){
            //             if(!visited[nrow][ncol] && grid[nrow][ncol] =='1' ){
            //                 visited[nrow][ncol] = true;
            //                 queue.add(new Pair(nrow, ncol));
            //             }
                        
            //         }


            //     }
            // }
        }

    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i = 0; i<n; i++){
            for (int j =0 ; j<m; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(i, j, grid, visited);
                    count++;
                }
            }
        }
    return count;
    }
}