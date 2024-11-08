class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0;
        int maxBit = (1 << maximumBit) - 1;
        for(int i = 0; i < nums.length; i++){
            xor = xor ^ nums[i];
        }
        int output[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            output[i] = xor ^ maxBit;
            xor = xor ^ nums[nums.length-1 - i];
        }
        return output;
    }
}