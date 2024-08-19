class Solution {
    private long nCr(int n, int r){
        long res = 1;
        for(long i = 0; i < r; i++){
            res = res * (n-i);
            res = res / (i+1) ;
        }
        return res;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++){
            result.add((int)nCr(rowIndex, i));
        }
        return result;
    }
}