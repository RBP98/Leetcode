class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        for(char c: s.toCharArray()){
            if(c == '1') totalOnes++;
        }

        if(totalOnes == 0) return 1;
        
        int leftZeroes = 0;
        int max = 0;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '1') 
                totalOnes--;
            else
                leftZeroes++;

            max = Math.max(max, leftZeroes + totalOnes);           
        }
    return max;
    }
}