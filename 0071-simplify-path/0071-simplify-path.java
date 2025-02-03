class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        for(String dir: path.split("/")){
            if(dir.isEmpty() || dir.equals(".")){
                continue;
            }else if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(dir);        
            }
        }

        StringBuilder canonicalPath = new StringBuilder();
        for(String s: stack){
            canonicalPath.append('/');
            canonicalPath.append(s);
        }

    return stack.isEmpty() ? "/" : canonicalPath.toString();
    }
}