class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer str = new StringBuffer();
        for(Character c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                str.append(Character.toLowerCase(c));
            }
        }
        String cleanString = str.toString();
        int left = 0;
        int right = cleanString.length() - 1;

        while(right > left){
            if(cleanString.charAt(left) == cleanString.charAt(right)){
                left++;
                right--;
            }
            else return false;
        }
    return true;
    }
}