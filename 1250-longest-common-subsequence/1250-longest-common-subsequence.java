class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return lcs(dp, text1, text2, text1.length(), text2.length());
    }

    public int lcs(int[][] dp, String s1, String s2, int i, int j){
        if(i == 0 || j == 0){
            dp[i][j] = 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i - 1) == s2.charAt(j - 1)){
            return dp[i][j] = 1 + lcs(dp, s1, s2, i-1, j-1);
        }
            
        else
            return dp[i][j] = Math.max(lcs(dp, s1, s2, i, j-1), lcs(dp, s1, s2, i-1, j));

    }


}