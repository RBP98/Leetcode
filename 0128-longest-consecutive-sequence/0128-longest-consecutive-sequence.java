class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int longestStreak = 0;
        for(int i : set){
            if(!set.contains(i - 1)){
                int currentNum = i;
                int currentStreak = 1;
                while(set.contains(currentNum + 1)){
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
    return longestStreak;
    } 
}