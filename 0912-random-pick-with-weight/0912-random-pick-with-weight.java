class Solution {
    int[] prefixWeight;
    int totalSum = 0;
    public Solution(int[] w) {
        prefixWeight =  new int[w.length];
        prefixWeight[0] = w[0];
        for(int i = 1; i < w.length; i++){
            prefixWeight[i] = prefixWeight[i - 1] + w[i];
        }
        totalSum = prefixWeight[w.length - 1];

    }
    
    public int pickIndex() {
        Random random = new Random();

        int target = random.nextInt(totalSum);

        for(int i = 0; i < prefixWeight.length; i++){
            if(target < prefixWeight[i]){
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