class Solution {
    public int calculate(String s) {
        int lastNumber = 0;
        int result = 0;
        int currNum = 0;
        int operator = '+';
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);

            if(Character.isDigit(currChar)){
                currNum = (currNum * 10) + currChar - '0';
            }

            if(currChar == '+' || currChar == '-' ||
               currChar == '*' || currChar == '/' || i == s.length() - 1){

                if(operator == '+' || operator == '-'){
                    result = result + lastNumber;
                    lastNumber = operator == '+' ? currNum : -currNum;

                }else if(operator == '*'){
                    lastNumber = lastNumber * currNum;
                }else{
                    lastNumber = lastNumber / currNum;
                }
                operator = currChar;
                currNum = 0;

            }
        }

        result = result + lastNumber;
        return result;
    }
}