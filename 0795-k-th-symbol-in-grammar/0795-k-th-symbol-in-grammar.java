class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1) return 0;

        int half = (int)Math.pow(2, n - 2);

        if(k > half){
            return 1 - kthGrammar(n, k - half);
        }else{
            return kthGrammar(n - 1, k);
        }
    }
}