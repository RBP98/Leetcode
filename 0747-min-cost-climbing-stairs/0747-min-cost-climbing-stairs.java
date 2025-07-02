class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int dp[] = new int[cost.length];
        Arrays.fill(dp, -1);

        return helper(cost, cost.length, dp);
        
    }

    private int helper(int[] cost, int n, int[] dp){
        // if(n == 0) return 0;
        if(n <= 1) return 0;
        if(dp[n-1] != -1) return dp[n - 1];
        int oneStep = cost[n - 1] + helper(cost, n - 1, dp);
        int twoStep = cost[n - 2] + helper(cost, n - 2, dp);

        return dp[n - 1] = Math.min(oneStep, twoStep);

        
    }

}