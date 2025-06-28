class Solution {
    public int rob(int[] nums) {
        
        return helper(nums, nums.length - 1);
    }

    private int helper(int[] nums, int n){
        if(n < 0) return 0;
        return Math.max(helper(nums, n - 2) + nums[n], helper(nums, n - 1));
        
    }
}