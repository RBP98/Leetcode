class Solution {
     
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return helper(grid, m - 1, n - 1, dp);
    }

    private int helper(int[][] grid, int m, int n, int[][] dp){
        if(m == 0 && n == 0) return grid[m][n];
        
        if(m < 0 || n < 0) return Integer.MAX_VALUE;

        if(dp[m][n] != Integer.MAX_VALUE){
            return dp[m][n];
        }
        return dp[m][n] = grid[m][n] + Math.min(helper(grid, m - 1, n, dp), helper(grid, m, n - 1, dp));

    }
}