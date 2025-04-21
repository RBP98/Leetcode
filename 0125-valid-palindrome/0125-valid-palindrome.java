class Solution {
    public boolean isPalindrome(String s) {
        // Create sanitized string
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        String sanitized = sb.toString();
        //Init two pointers
        int left = 0;
        int right = sanitized.length() - 1;
        //Run a loop until left ptr < right ptr
        while(left < right){

        
        //if char At left == char At right then incr left and decr right
            if(sanitized.charAt(left) != sanitized.charAt(right)){
                return false;        
            }
            left++;
            right--;
        }
        return true;
    }
}