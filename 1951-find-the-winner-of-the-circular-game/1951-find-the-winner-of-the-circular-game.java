class Solution {
    public int findTheWinner(int n, int k) {
        return helper(n, k) + 1;
    }

    private int helper(int n, int k){ 
        if(n == 1) return 0; 
        int res = (helper(n - 1, k) + k) % n;
        return res;
    }
}