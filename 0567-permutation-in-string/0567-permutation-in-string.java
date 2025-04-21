class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] freqArr1 = new int[26];
        int[] freqArr2 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            freqArr1[s1.charAt(i) - 'a']++;
            freqArr2[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s2.length() - s1.length(); i++){
            if(isFreqArrSame(freqArr1, freqArr2)){
                return true;
            }
            int leftIndex = i; 
            int rightIndex = s1.length() + i;
            freqArr2[s2.charAt(leftIndex) - 'a']--;
            freqArr2[s2.charAt(rightIndex) - 'a']++;

        }
        return isFreqArrSame(freqArr1, freqArr2);
    }

    private boolean isFreqArrSame(int[] freqArr1, int[] freqArr2){
        for(int i = 0; i < 26; i++){
            if(freqArr1[i] != freqArr2[i]){
                return false;
            }
        }
        return true;
    }
}