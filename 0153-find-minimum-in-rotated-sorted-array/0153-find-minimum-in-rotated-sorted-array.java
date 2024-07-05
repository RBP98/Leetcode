class Solution {
    public int findMin(int[] nums) {
        int min = 5001;
        int high = nums.length - 1;
        int low = 0;

        while(low <= high){
            int mid = (low + high)/2;
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