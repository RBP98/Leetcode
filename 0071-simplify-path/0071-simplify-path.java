class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack();
        for(String s: path.split("/")){
            if(s.equals(".") || s.length() == 0){
                continue;
            }

            if(s.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
            else if(!s.equals("..")){
                stack.push(s);
            }
            
        }

        for(String s: stack){
            sb.append("/");
            sb.append(s);
        }
    return stack.isEmpty() ? "/" : sb.toString();
    }
}