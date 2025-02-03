class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int currNum = 0;
        char operator = '+';
          
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            StringBuilder sb = new StringBuilder();
            sb.append(curr);
            if(Character.isDigit(curr)){
                currNum = 10 * currNum + (curr - '0');    
            }
            if("*/-+".contains(sb.toString()) || i == s.length() - 1){
                if(operator == '-'){
                    stack.push(-currNum);
                }
                else if(operator == '+'){
                    stack.push(currNum);
                }
                else if(operator == '*'){
                    stack.push(stack.pop() * currNum);
                }
                else if(operator == '/'){
                    stack.push(stack.pop() / currNum);
                }
            operator = curr;
            currNum = 0;
            }
        }

        int res = 0;
        while(!stack.isEmpty()){
            res = res + stack.pop();
        }
        return res;
    }
}