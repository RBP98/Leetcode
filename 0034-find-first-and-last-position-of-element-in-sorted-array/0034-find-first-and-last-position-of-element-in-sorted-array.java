class Solution {
    private int lb(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int first = high + 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] >= target){
                first = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
    return first;
    }
    private int ub(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int last = high + 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] > target){
                last = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
    return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = lb(nums, target);
        int last = ub(nums, target) - 1;

        if(first == nums.length || nums[first] != target) return new int[]{-1, -1};
        return new int[]{first, last};
    }
}