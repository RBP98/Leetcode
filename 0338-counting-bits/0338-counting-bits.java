class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n + 1];
        while(n > 0){
            res[n] = Integer.bitCount(n);
            n--;
        }
        return res;
    }
}