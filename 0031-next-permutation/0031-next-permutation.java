class Solution {
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
        
    }

    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }


    public void nextPermutation(int[] nums) {
        
        int i = nums.length - 2;
        while(i >= 0 && nums[i + 1] <= nums[i]){
            i--;
        }

        if(i >= 0){
            int j = nums.length - 1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i , j);
        }
        reverse(nums, i + 1, nums.length - 1);

    }
}