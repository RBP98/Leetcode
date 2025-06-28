class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        return Math.max(robLinear(nums, 0, nums.length - 2), robLinear(nums, 1, nums.length - 1));
    }

    private int robLinear(int[] nums, int start, int end){
        
        int dp[] = new int[end - start + 1];
        Arrays.fill(dp, -1);
        return helper(nums, start, end, dp);
    }

    private int helper(int[] nums, int start, int end, int[] dp){
        
        if(end < start) return 0;
        int index = end - start;

        if(dp[index] != -1) return dp[index];

        return dp[index] = Math.max(helper(nums, start, end - 2, dp) + nums[end], helper(nums, start, end - 1, dp));
    }
}