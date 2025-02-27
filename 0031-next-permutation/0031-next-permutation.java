class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 
    private void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    } 
    public void nextPermutation(int[] nums) {
        int breakpoint = -1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i + 1] <= nums[i]){
                continue;
            }else{
                breakpoint = i;
                break;
            }
        }
    
        if(breakpoint != -1){
            for(int i = nums.length - 1; i >= breakpoint + 1; i--){
                if(nums[i] <= nums[breakpoint]){
                    continue;
                }else{
                    swap(nums, breakpoint, i);
                    break;
                }
            }
        }
        reverse(nums, breakpoint + 1, nums.length - 1); 
    }
}