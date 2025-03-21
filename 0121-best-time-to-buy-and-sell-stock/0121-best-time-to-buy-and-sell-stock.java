class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;

        int maxProf = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++){
            minSoFar = Math.min(prices[i], minSoFar);
            maxProf = Math.max(maxProf, prices[i] - minSoFar);
        }
        return maxProf;
    }
}