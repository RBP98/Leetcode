class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && c == stack.peek()){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}