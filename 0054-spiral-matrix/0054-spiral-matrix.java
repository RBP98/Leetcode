class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int left = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int bottom = m - 1;
        int right = n - 1;

        int count = 0;
        List<Integer> list = new ArrayList<>();
        while(count < m * n){
            for(int i = left; i <= right && count < m * n; i++){
                count++;
                list.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom && count < m * n; i++){
                count++;
                list.add(matrix[i][right]);
            }
            right--;

            for(int i = right; i >= left && count < m * n; i--){
                count++;
                list.add(matrix[bottom][i]);
            }
            bottom--;

            for(int i = bottom; i >= top && count < m * n; i--){
                count++;
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}