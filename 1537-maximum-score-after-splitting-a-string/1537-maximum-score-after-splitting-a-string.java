class Solution {
    public int maxScore(String s) {
        
        int leftZeroes = 0;
        int leftOnes = 0;
 
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '1') 
                leftOnes++;
            else
                leftZeroes++;

            max = Math.max(max, leftZeroes - leftOnes);

                       
        }
        if(s.charAt(s.length() - 1) == '1'){
                leftOnes++;
            }
    return leftOnes + max;
    }
}