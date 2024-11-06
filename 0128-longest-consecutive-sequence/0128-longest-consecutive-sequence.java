class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int i : nums){
            set.add(i);
        }
        int longestSeq = 0;
        for(int i : set){
            if(!set.contains(i - 1)){
                int seq = 0;
                int curr = i;
                while(set.contains(curr++)){
                    // curr++;
                    seq++;
                }
                longestSeq = Math.max(seq, longestSeq);
            }
        }

        return longestSeq;
    }
}