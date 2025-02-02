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
        int low = 0;
        int high = prefixSum.length;

        while(low < high){
            int mid = low + (high - low)/2;
            if(target > prefixSum[mid]){
                low = mid + 1;
            }else{
                high = mid;
            }
            
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */