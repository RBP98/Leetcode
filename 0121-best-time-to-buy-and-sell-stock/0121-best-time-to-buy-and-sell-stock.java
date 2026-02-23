class Solution {
    public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            minVal = Math.min(minVal, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minVal);
        }
        return maxProfit;
    }
}