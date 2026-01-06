class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int longest = 0;
        //abcabcbb          s.length() = 8 
        //left = 3
        //right = 6
        //set {}
        //longest = 3
        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                longest = Math.max(longest, right - left + 1);
                right++;
            
            }else{
                while(right < s.length() && set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
        }
        return longest;
    }
}