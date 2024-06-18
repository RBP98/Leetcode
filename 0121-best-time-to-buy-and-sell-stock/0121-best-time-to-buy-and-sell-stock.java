class Solution {
    public int maxProfit(int[] prices) {
        int start = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < start){
                start = prices[i];
            }
            int currProfit = prices[i] - start;
            if(currProfit > profit){
                profit = currProfit;
            }
        }
        return profit;
    }
}