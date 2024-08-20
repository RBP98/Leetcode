class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            int currProfit = prices[i] - min;
            if(currProfit > maxProfit){
                maxProfit = currProfit;
            }

        }
        return maxProfit;
    }
}