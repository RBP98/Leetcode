class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        int ans = 0;
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
            
        }while(fast != slow);
        fast = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
       
        return slow;
    }
}