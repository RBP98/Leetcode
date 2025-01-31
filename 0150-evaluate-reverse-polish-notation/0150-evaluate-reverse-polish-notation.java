class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int answer = 0;
        for(String s: tokens){
            if(!"+-/*".contains(s)){
                st.push(Integer.parseInt(s));
                continue;
            }
            int second = st.pop();
            int first = st.pop();

            if(s.equals("+")){
                answer = first + second;
            }
            else if(s.equals("-")){
                answer = first - second;
            }
            else if(s.equals("*")){
                answer = first * second;
            }
            else if(s.equals("/")){
                answer = first / second;
            }
            st.push(answer);
        }
        return st.peek();
    }
}