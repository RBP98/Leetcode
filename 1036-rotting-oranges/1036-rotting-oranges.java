class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int fresh = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){  
                    queue.add(new Pair(i,j));
                    visited[i][j] = true;
                    // break;
                }
                else if(grid[i][j] == 1){
                    fresh++;                   
                }
            }
        }

        if(fresh == 0) return 0;
        
        // queue.add(new Pair(sr, sc));
        // visited[sr][sc] = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            System.out.println(size);
            for(int s = 0; s < size; s++){
                Pair temp = queue.poll();
            
                int[] drow = {0, 1, 0, -1};
                int[] dcol = {1, 0, -1, 0};

                for(int i = 0; i < 4; i++){
                    int nrow = temp.first + drow[i];
                    int ncol = temp.second + dcol[i];

                    if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && !visited[nrow][ncol] && grid[nrow][ncol] == 1){
                        grid[nrow][ncol] = 2;
                        visited[nrow][ncol] = true;
                        queue.add(new Pair(nrow, ncol));
                        fresh--;
                    }
                }
            }
            
            count++;
        }
     
    return fresh==0 ? count -1: -1;
    }
}