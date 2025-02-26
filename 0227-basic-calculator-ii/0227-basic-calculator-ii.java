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

            if(currChar == '+' || currChar == '-' || 
               currChar == '*' || currChar == '/' || i == s.length() - 1){
                //  switch (operator) {
                //     case '+':
                //         result += lastNumber;
                //         lastNumber = currentNumber;
                //         break;
                //     case '-':
                //         result += lastNumber;
                //         lastNumber = -currentNumber;
                //         break;
                //     case '*':
                //         lastNumber *= currentNumber;
                //         break;
                //     case '/':
                //         lastNumber /= currentNumber;
                //         break;
                // }

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