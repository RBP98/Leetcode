class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {

    private int bfs(int row, int col, int m, int n, boolean[][] visited, int[][] grid){
        Queue<Pair> queue = new LinkedList<>();
        int area = 1;
        queue.add(new Pair(row, col));
        visited[row][col] = true;

        while(!queue.isEmpty()){
            Pair p = queue.poll();

            int drow[] = {0, 1, 0, -1};
            int dcol[] = {1, 0, -1, 0};

            for(int i = 0; i < 4; i++){
                int nrow = p.first + drow[i];
                int ncol = p.second + dcol[i];

                if(nrow >= 0 && ncol >=0 && nrow < m && ncol < n && !visited[nrow][ncol] && grid[nrow][ncol] == 1){
                    queue.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = true;
                    area++;
                }
            }
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    int area = bfs(i, j, m, n, visited, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}