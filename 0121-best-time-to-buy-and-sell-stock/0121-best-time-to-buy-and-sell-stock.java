class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = Integer.MIN_VALUE;
        int minSoFar = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            minSoFar = Math.min(minSoFar, prices[i]);

            maxProfit = Math.max(maxProfit, prices[i] - minSoFar); 
        }

        return maxProfit;
    }
}