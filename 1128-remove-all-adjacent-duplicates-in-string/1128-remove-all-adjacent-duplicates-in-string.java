class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(!st.isEmpty() && c == st.peek()){
                st.pop();
            }else{
                st.push(c);
            }
            
        }
        StringBuilder sb = new StringBuilder();
        for(char c: st){
            sb.append(c);
        }

        return sb.toString();
    }
}