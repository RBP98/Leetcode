class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int left = 0;
        int right = 0;
        int currentLongest = 0;
        while(right < s.length()){
            if(!hs.contains(s.charAt(right))){
                hs.add(s.charAt(right));
                right++;
                currentLongest = Math.max(hs.size(), currentLongest);
            }else{
                hs.remove(s.charAt(left));
                left++;
            }
        }      
    return currentLongest;
    }

}