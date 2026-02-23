class Solution {
    public int maxProfit(int[] prices) {
        int[] leftBest = new int[prices.length];
        int[] rightBest = new int[prices.length];

        int minVal = prices[0];

        for(int i = 1; i < prices.length; i++){
            minVal = Math.min(minVal, prices[i]);
            leftBest[i] = Math.max(leftBest[i - 1], prices[i] - minVal);
        }

        int maxVal = prices[prices.length-1];

        for(int i = prices.length - 2; i >= 0; i--){
            maxVal = Math.max(maxVal, prices[i]);
            rightBest[i] = Math.max(rightBest[i + 1], maxVal - prices[i]);
        }
        int ans = 0;
        for(int i = 0; i < prices.length; i++){
            ans = Math.max(ans, rightBest[i] + leftBest[i]);
        }

        return ans;
    }
}