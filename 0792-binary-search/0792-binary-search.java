class Solution {
    public boolean isBefore(int num, int target){
        return num < target;
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        if(n == 0 || isBefore(nums[r], target)) return -1;
        if(nums[l] == target) return l;

        while(r - l > 1){
            int mid = l + (r - l)/2;
            if(isBefore(nums[mid], target)) l = mid;
            else r = mid; 
        }
        return nums[r] == target ? r : -1;
    }
}