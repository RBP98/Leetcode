class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;

        int[] s1Char = new int[26];
        int[] s2Char = new int[26];

        int charDiff = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                charDiff++;

                if(charDiff > 2) return false;
            }

            s1Char[s1.charAt(i) - 'a']++;
            s2Char[s2.charAt(i) - 'a']++;

        }
    return Arrays.equals(s1Char, s2Char);    
    }
}