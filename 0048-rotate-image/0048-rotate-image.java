class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i > j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
                
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(j < matrix[0].length/2){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix[0].length-1 -j];
                    matrix[i][matrix[0].length-1 -j] = temp;
                }
            }

        }
    }
}