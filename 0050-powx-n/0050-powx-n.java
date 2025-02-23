class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n < 0){
            x = 1/x;
            N = -N;
        }
        return helper(x, N);
    }
    double ans = 1;
    private double helper(double x, long n){
        // if(x == 0 && n == 1) return 0;
        if(n == 0) return 1;
        // if(x == 1 || n == 1){
        //     return x;
        // }
        if(n%2 == 1){
            return x * helper(x * x, n / 2);
        }else{
            return helper(x * x, n / 2);
        }
    }
}