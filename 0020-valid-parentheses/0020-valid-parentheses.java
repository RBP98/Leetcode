class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{            
                if(!stack.isEmpty()){
                    if((c == ')' && stack.peek() == '(') ||
                      (c == ']' && stack.peek() == '[') ||
                      (c == '}' && stack.peek() == '{')){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}