class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));                
            }
        }
        String cleanString = sb.toString();
        int left = 0;
        int right = cleanString.length() - 1;

        while(left < right){
            if(cleanString.charAt(left) != cleanString.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}