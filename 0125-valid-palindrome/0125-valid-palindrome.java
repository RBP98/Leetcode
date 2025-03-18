class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        
        String sani = sb.toString();
        
        int left = 0;
        int right = sani.length() - 1;

        while(left < right){
            if(sani.charAt(left) != sani.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}