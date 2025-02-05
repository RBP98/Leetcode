class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder s1 = new StringBuilder(num1);
        StringBuilder s2 = new StringBuilder(num2);
        s1.reverse();
        s2.reverse();

        StringBuilder outputString = new StringBuilder();
        for(int i = 0; i < num1.length() + num2.length(); i++){
            outputString.append(0);
        }
        for(int i = 0; i < s2.length(); i++){
            int digit2 = s2.charAt(i) - '0';           
            for(int j = 0; j < s1.length(); j++){
                int current = i + j;
                
                int digit1 = s1.charAt(j) - '0';
              
                int carry = outputString.charAt(current) - '0';
                int product = digit1 * digit2 + carry;
                outputString.setCharAt(current, (char) ((product % 10) + '0'));

                int value = outputString.charAt(current + 1) - '0';
                outputString.setCharAt(current + 1, (char) ((product/10 + value) + '0'));
            }
        }

        outputString.reverse();

        if(outputString.charAt(0) == '0'){
            outputString.deleteCharAt(0);
        }
        return outputString.toString();
    }
}