class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int max = 0;
        for(int i :nums){
            if(!set.contains(i - 1)){
                int count = 0;
                int curr = i;
            
                while(set.contains(curr++)){
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}