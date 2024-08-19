class Solution {
    private void markRow(int[][] matrix, int row){
        for(int i = 0; i < matrix[row].length; i++){
            matrix[row][i] = 0;
        }
    }
    private void markCol(int[][] matrix, int col){
        for(int i = 0; i < matrix.length; i++){
            matrix[i][col] = 0;
        }
    }
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row[i] = -1;
                    col[j] = -1;
                }
            }
        }
        for(int i = 0;i < row.length; i++){
            if(row[i] == -1){
                markRow(matrix, i);
            }
        }

        for(int i = 0;i < col.length; i++){
            if(col[i] == -1){
                markCol(matrix, i);
            }
        }

    }
}