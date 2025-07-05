class Cell{
    int row, col, time;
    public Cell(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.time, b.time));
        boolean[][] visited = new boolean[n][n];

        pq.add(new Cell(0, 0, grid[0][0]));
        
        int[] drow = {0, 1, 0, -1};
        int[] dcol = {1, 0, -1, 0};

        while(!pq.isEmpty()){
            Cell c = pq.poll();

            int row = c.row;
            int col = c.col;
            int time = c.time;

            if(row == n-1 && col == n-1) return time; 

            for(int i = 0; i < 4; i++){
                int nrow = drow[i] + row;
                int ncol = dcol[i] + col;
                
                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < n && !visited[nrow][ncol]){
                    pq.add(new Cell(nrow, ncol, Math.max(time, grid[nrow][ncol])));
                    visited[nrow][ncol] = true;
                }
            }
        }
        return -1;
    }
}