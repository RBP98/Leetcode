class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        for(String s: path.split("/")){
            if(s.equals(".") || s.equals("")){
                continue;
            }

            if(!st.isEmpty() && s.equals("..")){
                st.pop();
            }else if(!s.equals("..")){
                st.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String str : st){
            sb.append("/");
            sb.append(str);
        }
        return st.isEmpty() ? "/": sb.toString();
    }
}