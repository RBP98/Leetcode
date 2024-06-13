class Solution {
    public void markCol(int col, int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            matrix[i][col] = 0;
        }
    }
    public void markRow(int row, int[][] matrix){
        for(int i = 0; i < matrix[0].length; i++){
            matrix[row][i] = 0;
        }
    }
    public void setZeroes(int[][] matrix) {
        int[] rowArr = new int[matrix.length];
        int[] colArr = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    colArr[j] = -1;
                    rowArr[i] = -1;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            if(rowArr[i] == -1){
                markRow(i, matrix);
            }
        }

        for(int i = 0; i < matrix[0].length; i++){
            if(colArr[i] == -1){
                markCol(i, matrix);
            }
        }
    }
}