class Solution {
    int[][] dp;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for(int i = 0 ; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(m - 1, n - 1, grid);
        // return dp[m - 1][n - 1];
    }

    private int helper(int i, int j, int[][] grid){
        if(i < 0 || j < 0) return Integer.MAX_VALUE;

        if(i == 0 && j == 0) return grid[i][j];
       
        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = grid[i][j] + Math.min(helper(i - 1, j, grid), helper(i, j - 1, grid));
    }
}