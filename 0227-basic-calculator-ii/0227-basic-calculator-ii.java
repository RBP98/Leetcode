class Solution {
    public int calculate(String s) {
        int lastNumber = 0;
        int currentNumber = 0;

        int result = 0;
        char operator = '+';
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);

            if(Character.isDigit(currChar)){
                currentNumber = (currentNumber * 10) + currChar - '0';
            }

            if(!Character.isDigit(currChar) && 
               !Character.isWhitespace(currChar) || i == s.length() - 1){
                if(operator == '+'){
                    result +=lastNumber;
                    lastNumber = currentNumber;
                }else if(operator == '-'){
                    result +=lastNumber;
                    lastNumber = -currentNumber;
                }else if(operator == '*'){
                    lastNumber = lastNumber * currentNumber;
                }else if(operator == '/'){
                    lastNumber = lastNumber / currentNumber;
                }

                operator = currChar;
                currentNumber = 0;

            }
            
            
        }
        result +=lastNumber;
        return result;
    }
}