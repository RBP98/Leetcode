class Solution {

    int[] prefixSum;
    int total;
    public Solution(int[] w) {
        prefixSum = new int[w.length];
        total = 0;
        prefixSum[0] = w[0];
        for(int i = 1; i < w.length; i++){
            prefixSum[i] = prefixSum[i-1] + w[i];
        }

        total = prefixSum[w.length - 1];
    }
    
    public int pickIndex() {
        double target = total * Math.random();
        for(int i = 0; i < prefixSum.length; i++){
            if(target < prefixSum[i]){
                return i;
            }
        }
    return -1;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */