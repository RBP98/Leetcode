class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n < 0){
            N = -n;
            return helper(1/x, N);
        }

        return helper(x, N);

    }

    private double helper(double x, long n){
        if(n == 0) return 1;

        if(n % 2 != 0){
            return x * helper(x * x, n / 2);
        }
        // else{
            return helper(x * x, n / 2);
        // }

      
    }
}