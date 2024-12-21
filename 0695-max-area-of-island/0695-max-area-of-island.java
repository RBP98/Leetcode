//Same as number of islands. Except counting the islands, here we count the size of each island in the bfs and compare it with maxArea while updating maxArea each time area of current island is greater than maxArea


class Pair{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {

    private int bfs(int row, int col, boolean[][] visited,int[][] grid, int m, int n){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row][col] = true;
        int area = 1;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int first = p.first;
            int second = p.second;

            int[] drow = {0, 1, 0, -1};
            int[] dcol = {1, 0, -1, 0};

            for(int i = 0; i < 4; i++){
                int nrow = first + drow[i];
                int ncol = second + dcol[i];

                if(nrow >= 0 && nrow < m && ncol >=0 && ncol < n && !visited[nrow][ncol] && grid[nrow][ncol] == 1){
                    visited[nrow][ncol] = true;
                    queue.add(new Pair(nrow, ncol));
                    area++;
                }
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxArea = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int currentArea = bfs(i, j, visited, grid, m, n); 
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

    return maxArea;
    }
}