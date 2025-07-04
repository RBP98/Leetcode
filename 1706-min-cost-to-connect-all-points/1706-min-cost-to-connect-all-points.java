class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int edgesUsed = 0;
        int totalCost = 0;
        boolean inMST[] = new boolean[n];
        
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        while(edgesUsed < n){
            int currEdgeCost = Integer.MAX_VALUE;
            int curr = -1;
            for(int i = 0; i < n; i++){
                if(!inMST[i] && minDist[i] < currEdgeCost){
                    currEdgeCost = minDist[i];
                    curr = i; 
                }
            }

            inMST[curr] = true;
            totalCost = totalCost + currEdgeCost;
            edgesUsed++;

            for(int i = 0; i < n; i++){
                int cost = Math.abs(points[curr][0] - points[i][0]) + Math.abs(points[curr][1] - points[i][1]);
                if(!inMST[i]){
                    minDist[i] = Math.min(cost, minDist[i]);
                }
            }
        }
        return totalCost;
    }
}