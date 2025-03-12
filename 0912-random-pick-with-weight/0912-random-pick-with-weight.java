class Solution {
    int prefix[];
    public Solution(int[] w) {
        prefix = new int[w.length];
        prefix[0] = w[0];
        for(int i = 1; i < w.length; i++){
            prefix[i] = prefix[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        // Random random = new Random();
        int total = prefix[prefix.length - 1];
        int index = new Random().nextInt(total + 1);

        // double index = total * Math.random();

        int low = 0;
        int high = prefix.length;

        while(low < high){
            int mid = low + (high-low)/2;
            if(index <= prefix[mid]){
                high = mid;
            }else{
                low = mid + 1;
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