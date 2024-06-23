class Solution {
    public String removeKdigits(String s, int k) {
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            
            while(!stack.isEmpty() && k > 0 && stack.peek() > s.charAt(i)){
                stack.pop();
                k--;
            }        
            stack.push(s.charAt(i));
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        int start = 0;
        while (start < sb.length() && sb.charAt(start) == '0') {
            start++;
        }
     return sb.substring(start).isEmpty() ? "0" : sb.substring(start);
    }
}