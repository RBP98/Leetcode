class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] prevRow = null;
        for(int[] row: matrix){
            for(int j = 1; j < n; j++){
                if(prevRow != null && prevRow[j - 1] != row[j]){
                    return false;
                }
            }
            prevRow = row;
        }
        return true;
    }
}