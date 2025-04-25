class Solution {
    public int maxPower(String s) {
        int left = 0;
        int right = 0;
        int longest = 0;
        while(right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                right++;
                longest = Math.max(longest, right - left);
                continue;
            }
            left = right;
        }
        return longest;
    }
}