class Solution {
    public int findMin(int[] nums) {
        int min = 5001;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                min = Math.min(min, nums[low]);
                low++;
                high--;
                continue;
            }

            if(nums[low] <= nums[mid]){
                min = Math.min(min, nums[low]);
                low = mid + 1;
            }else{
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }

            
        }
    return min;
    }
}