class Solution {
    public double myPow(double x, int n) {
        // int sign = 1;
        if(n < 0){
            return helper((1/x) , -n);
        }

        return helper(x, n);
    }

    private double helper(double x, long n){
        if(n == 0) return 1;
        if(n % 2 == 1){
            return x * helper(x * x, n/2);
        }
        return helper(x * x, n/2);
    }
}