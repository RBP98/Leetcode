class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sanitized = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                sanitized.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        String sanitizedString = sanitized.toString();
        int left = 0;
        int right = sanitizedString.length()-1;
        while(left < right){
            if(sanitizedString.charAt(left) != sanitizedString.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}