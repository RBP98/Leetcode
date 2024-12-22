class Pair {
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                }
                if(grid[i][j] == 2){
                    queue.add(new Pair(i, j));
                }
            }
        }
        int minutes = 0;
        if(freshOranges == 0) return 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rottenThisRound = false;
            for(int l = 0; l < size; l++){
                Pair p = queue.poll();
                int first = p.first;
                int second = p.second;

                int drow[] = {0, 1, 0, -1};
                int dcol[] = {1, 0, -1, 0};

                for(int i = 0; i < 4; i++){
                    int nrow = first + drow[i];
                    int ncol = second + dcol[i];

                    if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1){
                        queue.add(new Pair(nrow, ncol));
                        grid[nrow][ncol] = 2;
                        freshOranges--;
                        rottenThisRound = true;
                    }
                }
            }
            if (rottenThisRound) {
                minutes++;
            }
        }
        return freshOranges == 0 ? minutes  : -1;
    }
}
