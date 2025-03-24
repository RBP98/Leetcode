class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        while(i < s.length() && s.charAt(i) == ' ') i++;
        if(i < s.length() && s.charAt(i) == '+'){
            sign = 1;
            i++;
        }else if(i < s.length() && s.charAt(i) == '-'){
            sign = -1;
            i++;
        }

        int num = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int value = s.charAt(i) - '0';
            if(num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && value > Integer.MAX_VALUE%10)){
                return sign == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }
            num = num * 10 + value;
            i++;
        }

        return sign == 1 ? num : -num;
    }
}