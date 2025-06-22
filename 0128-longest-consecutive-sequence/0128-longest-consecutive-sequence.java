class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if(nums.length == 0) return 0;
        for(int i : nums){
            set.add(i);
        }
        int longest = 0;
        for(int i: set){
            int seq = 0;
            if(!set.contains(i - 1)){
                while(set.contains(i++)){
                    seq++;
                    
                }
            }
            longest = Math.max(seq, longest);
        }
        return longest;
    }
}