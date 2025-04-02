class Solution {
    public boolean isAnagram(String s, String t) {
        int freqArr[] = new int[26];
        for(int i: s.toCharArray()){
            freqArr[i - 'a']++;
        }
        for(int i: t.toCharArray()){
            if(freqArr[i - 'a'] == 0){
                return false;
            }
            freqArr[i - 'a']--;
        }

        for(int i: freqArr){
            if(i != 0) return false;
        }
        return true;
    }
}