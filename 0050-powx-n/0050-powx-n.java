class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n < 0){
            x = 1/x;
            N = -N;
        }
        return helper(x, N);
    }
    private double helper(double x, long n){
        if(n == 0) return 1;
        if(n%2 == 1){
            return x * helper(x * x, n / 2);
        }else{
            return helper(x * x, n / 2);
        }
    }
}