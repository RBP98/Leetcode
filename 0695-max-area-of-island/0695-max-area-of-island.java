class Solution {
    public int bfs(int r, int c, int rows, int cols, boolean[][] visited, int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.add(new int[]{r, c});
        int count = 1;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int first = temp[0];
            int second = temp[1];

            int[] drow = {0, 1, 0, -1};
            int[] dcol = {1, 0, -1, 0};
            
            for(int i = 0; i < 4; i++){
                int nrow = first + drow[i];
                int ncol = second + dcol[i];

                if(nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && grid[nrow][ncol] == 1 && !visited[nrow][ncol]){
                    queue.add(new int[]{nrow, ncol});
                    visited[nrow][ncol] = true;
                    count++;
                }
            }



        }
        return count;

    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        boolean visited[][] = new boolean[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    maxArea = Math.max(maxArea, bfs(i, j, rows, cols, visited, grid));
                }
            }
        }

        return maxArea;
    }
}