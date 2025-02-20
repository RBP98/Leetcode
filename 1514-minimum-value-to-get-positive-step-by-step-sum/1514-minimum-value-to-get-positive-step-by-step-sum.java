class Solution {
    public int minStartValue(int[] nums) {
        int minPrefixSum = 0;
        int prefixSum = 0;

        for(int i = 0; i < nums.length; i++){
            prefixSum = prefixSum + nums[i];
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
        }

        return -minPrefixSum + 1;
    }

}