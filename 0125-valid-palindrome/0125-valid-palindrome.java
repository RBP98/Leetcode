class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
                str.append(Character.toLowerCase(s.charAt(i)));
        }
        String st = str.toString();
        int left = 0;
        int right = st.length() - 1;
        while(right > left){
            if(st.charAt(left) != st.charAt(right)){
                return false;
            }

            right--;
            left++;
        }
    return true;
    }
}