class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int number = 1;
        
        while(number <= n*n){
          
            for(int i = left; i <= right && number <= n*n; i++){
                matrix[top][i] = number;   
                number++;
            }
            top++;

            for(int i = top; i <= bottom && number <= n*n; i++){
                matrix[i][right] = number;
                number++;
            }
            right--;

            for(int i = right; i >= left && number <= n*n; i--){
                matrix[bottom][i] = number;
                number++;
            }
            bottom--;

            for(int i = bottom; i >= top && number <= n*n; i--){
                matrix[i][left] = number;
                number++;
            }
            left++;

        
        }
    return matrix;
    }
}