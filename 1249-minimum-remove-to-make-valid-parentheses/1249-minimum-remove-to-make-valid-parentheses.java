class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> invalidIndices = new HashSet<>();
        ArrayDeque<Integer> stack = new ArrayDeque();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)) continue;

            
            if(c == ')'){
                if(stack.isEmpty()){
                    invalidIndices.add(i);
                }else{
                    stack.pop();
                } 
            }else{
                stack.push(i);
            }
        }

        while(!stack.isEmpty()){
            invalidIndices.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!invalidIndices.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}