class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;

        int[] freq = new int[26];

        int longest = Integer.MIN_VALUE;
        int maxFreq = 0;
        while(right < s.length()){
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while(right - left + 1 > maxFreq + k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            longest = Math.max(longest, right - left + 1);
            right++;

        }
        return longest;
    }
}