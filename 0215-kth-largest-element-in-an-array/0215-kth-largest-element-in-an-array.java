class Solution {
    public int findKthLargest(int[] nums, int k) {
        // minValue
        // maxValue

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        
        for(int i: nums){
            minValue = Math.min(minValue, i);
            maxValue = Math.max(maxValue, i);
        }

        int[] freqArr = new int[maxValue - minValue + 1];

        for(int i: nums){
            freqArr[i - minValue]++;
        }

        for(int i = freqArr.length - 1; i >= 0; i--){
            if(freqArr[i] > 0){
                k = k - freqArr[i];

                if(k <= 0){
                    return i + minValue;
                }
            }


        }

        return -1;

        // maxValue - minValue + 1
    }
}