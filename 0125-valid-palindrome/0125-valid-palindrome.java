class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                str.append(Character.toLowerCase(c));
            }
        } 

        String cleaned = str.toString();

        int left = 0;
        int right = cleaned.length() - 1;

        while(left < right){
            if(cleaned.charAt(left) != cleaned.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}