class Solution {
    public String simplifyPath(String path) {
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
        StringBuilder sb = new StringBuilder();
    
        for(String s: stack){
            sb.append("/");
            sb.append(s);
        }
    return stack.isEmpty() ? "/" : sb.toString();
    }
}