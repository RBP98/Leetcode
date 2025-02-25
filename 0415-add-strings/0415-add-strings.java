class Solution {
    public String addStrings(String num1, String num2) {
        if(num1.length() == 0) return num2;
        if(num2.length() == 0) return num1;

        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int digit1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int digit2 = j < 0 ? 0 : num2.charAt(j) - '0';

            int value = digit1 + digit2 + carry;

            carry = value/10;
            sb.append(value % 10);

            i--;
            j--;
        }

        if(carry > 0) sb.append(carry);

        return sb.reverse().toString();
    }
}