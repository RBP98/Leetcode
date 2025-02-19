class Solution {
    public int maxProfit(int[] prices) {
        int minSofar = Integer.MAX_VALUE;
        int profit = 0;

        for(int i = 0; i < prices.length; i++){
            minSofar = Math.min(minSofar, prices[i]);
            profit = Math.max(profit, prices[i] - minSofar);
            
        }
        return profit;
    }
}