class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> queue = new LinkedList();
        int r = image.length;
        int c = image[0].length;
        int og = image[sr][sc];
        boolean[][] visited = new boolean[r][c];
        Pair p = new Pair(sr, sc);
        queue.add(p);
        image[sr][sc] = color;
        visited[sr][sc] = true;

        while(!queue.isEmpty()){
            Pair temp = queue.poll();

            int[] drow = {-1, 0, 1, 0};
            int[] dcol = {0, 1, 0, -1};

            for(int i=0; i<4; i++){
                int nrow = temp.first + drow[i];
                int ncol = temp.second + dcol[i];
                if(nrow >= 0 && ncol >= 0 && nrow < r && ncol < c && !visited[nrow][ncol] && image[nrow][ncol] == og){
                    visited[nrow][ncol] = true;
                    image[nrow][ncol] = color;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }
    return image;
    }
}