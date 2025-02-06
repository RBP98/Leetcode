class Solution {
    public int minAddToMakeValid(String s) {
        int extraBrackets = 0;
        int openBrackets = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                openBrackets++;
            }else{
                openBrackets--;
                if(openBrackets <= 0){
                    extraBrackets++;
                }
            }
        }

        return openBrackets + extraBrackets;
    }
}