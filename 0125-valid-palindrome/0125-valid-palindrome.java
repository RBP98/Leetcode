class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sanitized = new StringBuilder();

        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sanitized.append(Character.toLowerCase(c));
            }
        }

        String saniStr = sanitized.toString();

        int left = 0;
        int right = saniStr.length() - 1;

        while(left < right){
            if(saniStr.charAt(left) != saniStr.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}