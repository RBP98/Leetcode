class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i < j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
                
            }
        }
        int n = matrix[0].length;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }

    }
}