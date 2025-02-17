class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        while(i >= 0 || j >= 0){
            i = nextValidIndex(s, i);
            j = nextValidIndex(t, j);

            if(i < 0 && j < 0) return true;
            if(i < 0 || j < 0 || s.charAt(i) != t.charAt(j)) return false;

            i--;
            j--;
        }
        return true;
    }
    
    private int nextValidIndex(String str, int index){
        int backCount = 0;
        while(index >= 0){
            if(str.charAt(index) == '#'){
                backCount++;
                index--;
            }else if(backCount > 0){
                backCount--;
                index--;
            }else{
                break;
            }
        }
        return index;
    }
}