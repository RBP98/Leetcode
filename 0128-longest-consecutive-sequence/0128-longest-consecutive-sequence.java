class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int max = 0;
        for(int i: set){
            int count = 0;
            if(!set.contains(i - 1)){
                while(set.contains(i++)){
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}