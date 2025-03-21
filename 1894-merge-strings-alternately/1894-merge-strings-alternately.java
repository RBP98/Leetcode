class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;

        StringBuilder sb = new StringBuilder();
        while(i < word1.length() && j < word2.length()){
            sb.append(word1.charAt(i)).append(word2.charAt(j));
            i++;
            j++;
        }
        if(word1.length() > word2.length()){
            sb.append(word1.substring(i));
        }else{
            sb.append(word2.substring(j));
        }
        return sb.toString();
    }
}