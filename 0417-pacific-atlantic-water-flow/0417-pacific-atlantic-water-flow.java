class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    private void bfs(Queue<Pair> queue, boolean[][] visited, int[][] heights){
        while(!queue.isEmpty()){
            Pair p = queue.poll();
           
            int[] drow = {0, 1, 0,-1};
            int[] dcol = {1, 0, -1, 0};

            for(int i = 0; i < 4; i++){
                int nrow = p.first + drow[i]; 
                int ncol = p.second + dcol[i];

                if(nrow >= 0 && ncol >= 0 && nrow < heights.length && ncol < heights[0].length && !visited[nrow][ncol] && heights[nrow][ncol] >= heights[p.first][p.second]){
                    visited[nrow][ncol] = true;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<Pair> queueP = new LinkedList();
        Queue<Pair> queueA = new LinkedList();

        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visitedP = new boolean[m][n];
        boolean[][] visitedA = new boolean[m][n];

        for(int i = 0; i < m; i++){
            queueP.add(new Pair(i,0));
            visitedP[i][0] = true;
            queueA.add(new Pair(i,n-1));
            visitedA[i][n - 1] = true;
        }

        for(int i = 1; i < n; i++){
            queueP.add(new Pair(0, i));
            visitedP[0][i] = true;
            queueA.add(new Pair(m - 1, i - 1));
            visitedA[m - 1][ i - 1] = true;
        }

        bfs(queueP, visitedP, heights);
        bfs(queueA, visitedA, heights);
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                List<Integer> temp = new ArrayList<Integer>();
                if(visitedP[i][j] && visitedA[i][j]){
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }
    return list;
    }
}