class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1) return 0;
        int ans = 1;

        for(int i = n; i >= 0; i--){
            int half = (int)Math.pow(2, i - 2);
            if(k > half){
                ans = 1 - ans;
                k = k - half;
            }
        }
        if(ans != 0) return 0;

        return 1;
    }
}