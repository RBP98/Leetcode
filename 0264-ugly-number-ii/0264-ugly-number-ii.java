class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];

        int ind2 = 0;
        int ind3 = 0;
        int ind5 = 0;

        int mul2 = 2;
        int mul3 = 3;
        int mul5 = 5;
        uglyNumbers[0] = 1;
        
        for(int i = 1; i < n; i++){
            int nextUgly = Math.min(mul2, Math.min(mul3, mul5));

            uglyNumbers[i] = nextUgly;

            if(nextUgly == mul2){
                ind2++;
                mul2 = uglyNumbers[ind2] * 2;
            }
            if(nextUgly == mul3){
                ind3++;
                mul3 = uglyNumbers[ind3] * 3;
            }
            if(nextUgly == mul5){
                ind5++;
                mul5 = uglyNumbers[ind5] * 5;
            }
        }



        return uglyNumbers[n - 1];
    }
}