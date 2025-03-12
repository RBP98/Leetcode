class Solution {
    public int findKthLargest(int[] nums, int k) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for(int i: nums){
            minVal = Math.min(i, minVal);
            maxVal = Math.max(i, maxVal);
        }

        int[] freq = new int[maxVal - minVal + 1];

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            freq[num - minVal]++;
        }

        for(int i = freq.length - 1; i >= 0; i--){
            while(freq[i] != 0){
                k--;
                freq[i]--;
                if(k == 0){
                    return i + minVal;
                }
            }
        }
        return -1;
    }
}