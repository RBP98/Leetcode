class Solution {
    public int findTheWinner(int n, int k) {
        int last = 0;
        for(int i = 1; i <= n; i++){
            last = (last + k) % i;

        } 
        return last + 1;
    }
}