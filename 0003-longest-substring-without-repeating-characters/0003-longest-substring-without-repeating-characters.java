class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Set<Character> window = new HashSet<>();
        int longestSubstring = 0;
        while(right < s.length()){
            if(!window.contains(s.charAt(right))){
                window.add(s.charAt(right));
                right++;
                longestSubstring = Math.max(window.size(), longestSubstring);
            }else{
                while(window.contains(s.charAt(right))){
                    window.remove(s.charAt(left));
                    left++;
                }
            }
        }
        return longestSubstring;
    }
}