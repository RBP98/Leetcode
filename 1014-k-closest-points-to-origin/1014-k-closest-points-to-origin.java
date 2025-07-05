class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x,y) -> Integer.compare(
                ( (y[0] * y[0]) + (y[1] * y[1]) ), 
                ( (x[0] * x[0]) + (x[1] * x[1]) )
            )
        );

        for(int[] point: points){
            pq.add(point);
            if(pq.size() > k) pq.poll();
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }

        return res;
    }
}