class Solution {
    public boolean isValid(String s) {
        Stack<Character> count = new Stack<>();
        
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                count.push(c);
            } else {
                if(!count.isEmpty()){
                     if (((c == ')' && count.peek() == '(')
                    || (c == ']' && count.peek() == '[')
                    || (c == '}' && count.peek() == '{'))
                    ) {
                count.pop();
                }else{
                    return false;
                }
            }else{
                return false;
            }
               
            }
            
        }
    return count.isEmpty();
    }
}