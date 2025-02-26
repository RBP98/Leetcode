class Solution {
    public int findKthLargest(int[] nums, int k) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer. MIN_VALUE;
        for(int i: nums){
            minVal = Math.min(i, minVal);
            maxVal = Math.max(i, maxVal);
        }

        int[] freqArr = new int[maxVal - minVal + 1];

        for(int i = 0; i < nums.length; i++){
            freqArr[nums[i] - minVal]++;
        }
        int index = k;
        for(int i = freqArr.length - 1; i >=0; i--){
            index = index - freqArr[i];
            if(index <= 0){
                return i + minVal;
            }
            
        }

    return -1;
    }
}