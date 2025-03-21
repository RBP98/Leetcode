class Solution {
    public int minAddToMakeValid(String s) {
        int openBrackets = 0;
        int extraBrackets = 0;

        for(char c: s.toCharArray()){
            if(c == '('){
                openBrackets++;
            }else{
                if(openBrackets == 0){
                    extraBrackets++;
                }else{
                    openBrackets--;
                }
            }
        }
        return openBrackets + extraBrackets;
    }
}