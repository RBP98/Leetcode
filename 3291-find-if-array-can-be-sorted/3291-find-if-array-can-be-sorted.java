class Solution {
    private int countSetBits(int num){
        int count = 0;;
        while(num != 0){
            if(num%2 == 1) count++;
            num = num/2;
        }
        return count;
    }

    public boolean canSortArray(int[] nums) {
        int maxOfSegment = nums[0];
        int minOfSegment = nums[0];
        int numOfSetBits = Integer.bitCount(nums[0]);
        int maxOfPrevSegment = Integer.MIN_VALUE;

        for(int i = 1; i < nums.length; i++){
            if(Integer.bitCount(nums[i]) == numOfSetBits){
                maxOfSegment = Math.max(maxOfSegment, nums[i]);
                minOfSegment = Math.min(minOfSegment, nums[i]);
            }else{
                if(maxOfPrevSegment > minOfSegment){
                    return false;
                }
                maxOfPrevSegment = maxOfSegment;
                numOfSetBits = Integer.bitCount(nums[i]);
                maxOfSegment = nums[i];
                minOfSegment = nums[i];
                
            }
            
        }

        if (minOfSegment < maxOfPrevSegment) {
            return false;
        }
        return true; 
    }
}