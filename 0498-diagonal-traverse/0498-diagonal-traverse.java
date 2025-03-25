class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        int m = mat.length;

        int n = mat[0].length;

        int result[] = new int[m * n];
        boolean goingUp = true;
        int row = 0;
        int col = 0;
        for(int i = 0; i < result.length; i++){
            result[i] = mat[row][col];

            if(goingUp){
                if(col == n-1){
                    row++;
                    goingUp = false;
                }
                else if(row == 0){
                    col++;
                    goingUp = false;
                }else{
                    row--;
                    col++;
                    
                }
            }else{
                if(row == m - 1){
                    col++;
                    goingUp = true;
                }
                else if(col == 0){
                    row++;
                    goingUp = true;
                }else{
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}