class Solution {
    public String reversePrefix(String word, char ch) {
        int start = 0;
        int end = word.indexOf(ch);
        System.out.println(end);
        int n = end + 1;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(word.charAt(end--));
        }
        for(int i = n; i < word.length(); i++){
            sb.append(word.charAt(i));
        }

        return sb.toString();
    }
}