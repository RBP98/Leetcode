class Solution {
    public double myPow(double x, int n) {
        
        return helper(x, (long)n);
    }

    public double helper(double x, long n){
        if(n == 0)
            return 1;
        if(n < 0){
            return 1 / helper(x, -1 * n);
        }
        if(n % 2 == 1){
            return x * helper(x * x, (n-1) / 2);
        }else{
            return helper(x * x, n / 2);
        }
    }
}