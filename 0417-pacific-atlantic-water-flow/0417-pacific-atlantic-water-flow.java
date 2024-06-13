class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}


class Solution {

    private void bfs(int[][] heights, boolean[][] visited, Queue<Pair> queue, int n, int m){
        int[] drow = {0, 1, 0, -1};
        int[] dcol = {1, 0, -1, 0};
       
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int first = p.first;
            int second = p.second;
            
            for(int i = 0; i < 4; i++){
                int nrow = first + drow[i];
                int ncol = second + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] && heights[nrow][ncol] >= heights[first][second]){
                    queue.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = true;
                }
            }

        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visitedA = new boolean[n][m];
        boolean[][] visitedP = new boolean[n][m];
        List<List<Integer>> list = new ArrayList<>();

        Queue<Pair> queueA = new LinkedList<>();
        Queue<Pair> queueP = new LinkedList<>();

        for(int i = 0; i < heights.length; i++){
            queueA.add(new Pair(i,m-1));
            visitedA[i][m-1] = true;
            queueP.add(new Pair(i,0));
            visitedP[i][0] = true;
        }

        for(int i = 0; i < heights[0].length; i++){
            queueA.add(new Pair(n-1,i));
            visitedA[n-1][i] = true;
            queueP.add(new Pair(0,i));
            visitedP[0][i] = true;
        }



        bfs(heights, visitedA, queueA, n, m);
        bfs(heights, visitedP, queueP, n, m);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visitedA[i][j] && visitedP[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }

    return list;
    }

}