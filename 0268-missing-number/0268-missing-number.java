class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1)/2;
        int actualSum = 0;
        for(int i = 0; i < nums.length; i++){
            actualSum += nums[i];
        }
        return sum - actualSum;
    }
}