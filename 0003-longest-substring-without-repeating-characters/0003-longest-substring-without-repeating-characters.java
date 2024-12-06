class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;

        int left = 0;
        int right = 0;
        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                max = Math.max(set.size(), max);
                right++;
            }else{
                // while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                // }
            }
        }
        return max;
    }
}