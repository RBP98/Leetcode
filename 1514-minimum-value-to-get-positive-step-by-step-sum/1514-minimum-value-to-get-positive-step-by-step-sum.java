class Solution {
    public int minStartValue(int[] nums) {
        int minPrefix = Integer.MAX_VALUE;
        int prefix = 0;
        for(int i = 0; i < nums.length; i++){
            prefix = prefix + nums[i];
            minPrefix = Math.min(minPrefix, prefix);
        }

        return minPrefix < 0 ? 1 - minPrefix: 1;
    }
}