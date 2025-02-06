class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOcc = binarySearch(nums, target, true);
        if(firstOcc == -1){
            return new int[]{-1, -1};
        }
        int lastOcc = binarySearch(nums, target, false);
        return new int[]{firstOcc, lastOcc};
    }

    private int binarySearch(int[] nums, int target, boolean firstTrueLastFalse){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                if(firstTrueLastFalse){
                    if(mid == low || nums[mid - 1] != target){
                        return mid;
                    }
                    high = mid - 1;
                }else{
                    if(mid == high || nums[mid + 1] != target){
                        return mid;
                    }
                    low = mid + 1;
                }
            }else if(target < nums[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}