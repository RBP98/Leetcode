class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int start = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < start){
                start = prices[i];
            }
            int profit = prices[i] - start;
            maxProfit = Math.max(profit, maxProfit);

        }
        return maxProfit;
    }
}