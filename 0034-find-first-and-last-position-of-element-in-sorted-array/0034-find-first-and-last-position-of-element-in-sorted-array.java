class Solution {
    private int first(int[] nums, int target){
        int low = 0; 
        int high = nums.length - 1;
        int first = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                first = mid;
                high = mid - 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return first;
    }
    private int last(int[] nums, int target){
        int low = 0; 
        int high = nums.length - 1;
        int last = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                last = mid;
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        return new int[]{first(nums,target), last(nums,target)};
    }
}