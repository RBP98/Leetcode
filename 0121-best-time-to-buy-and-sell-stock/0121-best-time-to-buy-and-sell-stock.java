class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        int end = 0;
        int maxProfit = 0;
        while(end < prices.length){
            if(prices[end] < prices[start]){
                start = end;
            }
            maxProfit = Math.max(maxProfit, prices[end] - prices[start]);
            end++;
        }

    return maxProfit;
    }
}