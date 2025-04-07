class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];

        for(int i = 0; i < coins.length; i++){
            Arrays.fill(dp[i], -1);
        }
        int result = helper(coins, amount, coins.length - 1);
        return result == Integer.MAX_VALUE - 1 ? -1 : result;
    }

    private int helper(int[] coins, int target, int n){
        
        if(target == 0) return 0;
        if(n < 0 || target < 0) return Integer.MAX_VALUE - 1;

        if(dp[n][target] != -1){
            return dp[n][target];
        }

        int take = Integer.MAX_VALUE - 1;
        if(coins[n] <= target){
            take = 1 + helper(coins, target - coins[n], n);
        }
        
        int notTake = helper(coins, target, n - 1);

        return dp[n][target] = Math.min(take, notTake);
    }
    
}