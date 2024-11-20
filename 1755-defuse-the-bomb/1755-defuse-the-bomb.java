class Solution {
    public int[] decrypt(int[] code, int k) {
        int output[] = new int[code.length];
        for(int i = 0; i < code.length; i++){
            int sum = 0;
            for(int j = 1; j <= Math.abs(k); j++){
                if( k > 0){
                    sum = sum + code[(i + j) % code.length];
                }
                else if(k < 0){
                     sum = sum + code[Math.abs(i - j + code.length) % code.length];
                }else{
                    return output;
                }
                output[i] = sum;
            }
        }
    return output;
    }
}