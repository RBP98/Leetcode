class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int start = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < start){
                start = prices[i];
            }
            maxProfit = Math.max(prices[i] - start, maxProfit);
        }
        return maxProfit;
    }
}