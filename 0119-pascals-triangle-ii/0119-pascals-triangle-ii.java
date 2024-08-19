class Solution {
    //BruteForce Approach
      
    /*private long nCr(int n, int r){
        long res = 1;
        for(long i = 0; i < r; i++){
            res = res * (n-i);
            res = res / (i+1) ;
        }
        return res;
    }*/
    public List<Integer> getRow(int rowIndex) {
      //BruteForce Approach
      /*  List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++){
            result.add((int)nCr(rowIndex, i));
        }
        return result;
        */

        List<Integer> result = new ArrayList<>();
        result.add(1);
        long temp = 1;
        for(int i = 0; i < rowIndex; i++){
            temp = temp * (rowIndex-i)/ (i + 1);
            result.add((int)temp);
        }
        return result;
    }
}