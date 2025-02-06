class Solution {
    public int minAddToMakeValid(String s) {
        int extraBrackets = 0;
        int openBrackets = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                openBrackets++;
            }else{
                if(openBrackets > 0){
                    openBrackets--;
                }else{
                    extraBrackets++;
                }
            }
        }

        return openBrackets + extraBrackets;
    }
}