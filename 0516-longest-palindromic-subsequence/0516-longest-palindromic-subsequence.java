class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder str = new StringBuilder(s);
        String rev = str.reverse().toString();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i-1) == rev.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][n];
    }
}