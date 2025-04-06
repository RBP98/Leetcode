class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1) return 0;
        int ans = 1;

        for(int i = n; i >= 0; i--){
            int maxK = (int)Math.pow(2, i - 1);
            if(k > (maxK)/2){
                ans = 1 - ans;
                k = k - (maxK)/2;
            }
        }
        if(ans != 0) return 0;

        return 1;
    }
}