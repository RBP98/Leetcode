class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = 0;
        int n = 0;

        StringBuilder sb = new StringBuilder();
        while(m < word1.length() && n < word2.length()){
            sb.append(word1.charAt(m));
            sb.append(word2.charAt(n));
            m++;
            n++;
        }
    return sb.append(word1.length() > word2.length() ? word1.substring(m) : word2.substring(n)).toString();
    }
}