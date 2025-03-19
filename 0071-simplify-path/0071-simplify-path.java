class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for(String s: path.split("/")){
            if(s.equals("") || s.equals(".")){
                continue;
            }

            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(s);
            }
        }
    
        StringBuilder sb = new StringBuilder();

        for(String s: stack){
            sb.append("/").append(s);
        }

        return stack.isEmpty() ? "/" : sb.toString();
    }
}