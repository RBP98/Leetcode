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
        while(number > 0 ){
            for(int i = left; i <= right && number>0; i++){
                list.add(matrix[top][i]);
                number--;
                System.out.println(i+ " " + number);

            }
            top++;
            for(int i = top; i <= bottom && number>0; i++){
                list.add(matrix[i][right]);
                number--;
                System.out.println(i+ " " + number);
            }
            right--;
            for(int i = right; i >= left&& number>0; i-- ){
                list.add(matrix[bottom][i]);
                number--;
                System.out.println(i+ " " + number);
            }
            bottom--;
            for(int i = bottom; i >= top&& number>0; i-- ){
                list.add(matrix[i][left]);
                number--;
                System.out.println(i+ " " + number);
            }
            left++;
        }

    return list;
    }
}