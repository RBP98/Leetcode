class Solution {
    private int[] nearestSmallestRight(int[] arr){
        Stack<Integer> stack = new Stack<Integer>();
        int[] output = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            if(stack.isEmpty()){
                output[i] = arr.length;
            }
            else if(arr[i] > arr[stack.peek()]){
                output[i] = stack.peek();
            }
            else if(arr[i] <= arr[stack.peek()]){
                while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    output[i] = arr.length;
                }else{
                    output[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        return output;
    }

    private int[] nearestSmallestLeft(int[] arr){
        Stack<Integer> stack = new Stack<Integer>();
        int[] output = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(stack.isEmpty()){
                output[i] = -1;
            }
            else if(arr[i] > arr[stack.peek()]){
                output[i] = stack.peek();
            }
            else if(arr[i] <= arr[stack.peek()]){
                while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    output[i] = -1;
                }else{
                    output[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        return output;
    }

    private int maxH(int[] heights){
        int[] width = new int[heights.length];
        int[] nsr = nearestSmallestRight(heights);
        int[] nsl = nearestSmallestLeft(heights);
        int maxArea = 0;
        // for(int j: nsr){
        //     System.out.print(j + " ");
        // }
        // System.out.println();

        // for(int j: nsl){
        //     System.out.print(j + " ");
        // }
        // System.out.println();
        
        for(int i = 0; i < width.length; i++){
            width[i] = nsr[i] - nsl[i] - 1;
            maxArea = Math.max(maxArea, width[i] * heights[i]);
        }

        return maxArea;

    } 
    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    heights[j] = heights[j] + 1;
                }else{
                    heights[j] = 0;
                }
            }
            for(int j: heights){
                System.out.print(j + " ");
            }
            System.out.println();
            maxArea = Math.max(maxArea, maxH(heights));
        }
        return maxArea;
    }
}