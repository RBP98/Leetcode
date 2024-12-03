class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i] - 1)){
                int count = 0;
                int curr = nums[i];
            
                while(set.contains(curr++)){
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}