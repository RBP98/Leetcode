class Solution {
    public int minAddToMakeValid(String s) {
        int openBrackets = 0;
        int extraBrackets = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
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