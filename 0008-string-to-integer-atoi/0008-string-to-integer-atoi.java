class Solution {
    public int myAtoi(String s) {
        int i = 0;
        while(i < s.length() && s.charAt(i) ==  ' ') i++;
        int sign = 1; 
        if(i < s.length() && s.charAt(i) == '+'){
            i++;
        }
        else if(i < s.length() && s.charAt(i) == '-'){
            sign = -1;
            i++;
        }

        int num = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            if(num > Integer.MAX_VALUE/10 || num == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10){
                return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;        
            }
            num = num * 10 + digit;
            i++;
        }

        return sign < 0 ? -num : num;
    }
}