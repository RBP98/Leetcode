class Solution {
    public int rob(int[] nums) {
        int robNext = nums[nums.length - 1];
        int robNextPlusOne = 0;

        for(int i = nums.length - 2; i >= 0; i--){
            int current = Math.max(robNext, robNextPlusOne + nums[i]);
            robNextPlusOne = robNext;
            robNext = current;
        }
        return robNext;
    }
}