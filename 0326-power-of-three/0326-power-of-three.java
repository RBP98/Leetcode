class Solution {
    public boolean isPowerOfThree(int n) {
        return helper(n);
    }

    public boolean helper(int n){
        if(n == 0 || n == 2) return false;
        if(n == 1) return true;

        if (n % 3 != 0) return false;

        return helper(n/3);
    }
}