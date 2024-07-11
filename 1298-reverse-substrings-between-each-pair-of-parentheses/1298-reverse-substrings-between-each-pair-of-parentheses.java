class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] pair = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        int currIndex = 0;
        int direction = 1;
        StringBuilder sb = new StringBuilder();
        for(currIndex = 0, direction = 1; currIndex < s.length(); currIndex = currIndex + direction){
            if(s.charAt(currIndex) == '(' || s.charAt(currIndex) == ')'){
                currIndex = pair[currIndex];
                direction = -direction;
            }else{
                sb.append(s.charAt(currIndex));
            }
        }
        return sb.toString();
    }
}