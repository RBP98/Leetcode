class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> output = new ArrayList<>();
        int top = 0;
        int bottom = m -1;
        int left = 0;
        int right = n - 1;
        int count = 0;

        while(count < m * n){
            for(int i = left; i <= right && count < m * n; i++){
                output.add(matrix[top][i]);
                count++;
            }
            top++;
            for(int i = top; i <= bottom && count < m * n; i++){
                output.add(matrix[i][right]);
                count++;
            }
            right--;
            for(int i = right; i >= left && count < m * n; i--){
                output.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            for(int i = bottom; i >= top && count < m * n; i--){
                output.add(matrix[i][left]);
                count++;
            }
            left++;
        }
    return output;
    }
}