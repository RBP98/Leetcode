class Solution {
    public int myAtoi(String s) {
        // if(s.length() == 0) return 0;
        int i = 0;
        int sign = 1;
        while(i < s.length() && s.charAt(i) == ' ') i++;
        if(i < s.length() && s.charAt(i) == '-'){
            sign = -1;
            i++;
        } 
        else if(i < s.length() && s.charAt(i) == '+'){
            i++;
        } 
        int num = 0;
        while(i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                int digit = s.charAt(i) - '0';
              if(num > Integer.MAX_VALUE/10 || ((num == Integer.MAX_VALUE/10) && (digit > (Integer.MAX_VALUE%10)))){ 
               
                    return sign == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
                }
                num = (num * 10) + digit;
                i++;   
            }else{
                break;
            }
        }

        return sign == 1 ? num : -num;
    }
}