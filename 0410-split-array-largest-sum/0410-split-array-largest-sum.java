class Solution {
    private boolean isBefore(int maxSum, int[] nums, int k){
        int splitsRequired = getSplitsRequired(maxSum, nums);
        return splitsRequired > k;
    }

    private int getSplitsRequired(int maxSum, int[] arr){
        int currSum = 0;
        int splitsRequired = 1;
        for(int i: arr){
            if(currSum + i > maxSum){
                splitsRequired++;
                currSum = i;
            }else{
                currSum += i;
            }
        }
        return splitsRequired;
    }

    public int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i: nums){
            max = Math.max(max, i);
            sum = sum + i;
        }

        int l = max;
        int r = sum;
        if(!isBefore(l, nums, k)){
            return l;
        }
        while(r - l > 1){
            int mid = (l + r) / 2;
            if(isBefore(mid, nums, k)){
                l = mid;
            }else{
                r = mid;
            }

        }
        return r;
    }
}