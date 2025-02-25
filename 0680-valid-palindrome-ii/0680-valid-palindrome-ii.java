class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
                continue;
            }

            return checkPalindrome(s, left, right - 1) || checkPalindrome(s, left + 1, right);
        }
        return true;
    }

    private boolean checkPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}