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
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(nums[j] < nums[i]){
                    if(Integer.bitCount(nums[j]) == Integer.bitCount(nums[i])){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}