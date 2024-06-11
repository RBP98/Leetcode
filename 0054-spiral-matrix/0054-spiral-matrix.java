class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        int number = m * n;
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = m - 1;
        while(number != 0 ){
            for(int i = left; i <= right; i++){
                list.add(matrix[top][i]);
                number--;
            }
            top++;
            for(int i = top; i <= bottom; i++){
                list.add(matrix[i][right]);
                number--;
            }
            right--;
            if(top <= bottom){
                for(int i = right; i >= left; i-- ){
                    list.add(matrix[bottom][i]);
                    number--;
                }
                bottom--;
            }
            if(left <= right){
                for(int i = bottom; i >= top; i-- ){
                    list.add(matrix[i][left]);
                    number--;
                }
                left++;
            }
            
        }

    return list;
    }
}