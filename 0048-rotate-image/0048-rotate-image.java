class Solution {
    public void rotate(int[][] matrix) {
        int[][] rotated = new int[matrix.length][matrix[0].length];
        int rotatedRow = matrix.length - 1;
        // int rotatedColumn = matrix[0].length;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                rotated[j][rotatedRow] = matrix[i][j];
            }
            rotatedRow--;
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = rotated[i][j];
            }
        }
         
    }
}