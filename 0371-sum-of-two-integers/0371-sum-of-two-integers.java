class Solution {
    public int getSum(int a, int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);

        int sign = a > 0 ? 1 : -1;

        if(x < y) return getSum(b, a);

        int answer = 0;

        if(a*b >= 0){

            while(y != 0){
                answer = x ^ y;
                int carry = (x & y) << 1;
                x = answer;
                y = carry;
            }
            
        }else{
            while(y != 0){
                answer = x ^ y;
                int borrow = ((~x) & y) << 1;
                x = answer;
                y = borrow;
            }
        }
        return x * sign;
    }
}