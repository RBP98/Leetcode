class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if(nums.length == 0) return 0;
        for(int i : nums){
            set.add(i);
        }
        int longest = 1;
        for(int i: set){
            int seq = 1;
            if(!set.contains(i - 1)){
                while(set.contains(i + 1)){
                    seq++;
                    longest = Math.max(seq, longest);
                    i++;
                }
            }
        }
        return longest;
    }
}