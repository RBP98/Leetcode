class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int longestSeq = 0;
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i] - 1)){
                int seq = 0;
                int curr = nums[i];
                while(set.contains(curr++)){
                    seq++;
                }
                longestSeq = Math.max(seq, longestSeq);
            }
        }

        return longestSeq;
    }
}