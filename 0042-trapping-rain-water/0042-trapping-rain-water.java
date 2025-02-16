class Solution {
    public int trap(int[] height) {
        int n = height.length;
        // int[] leftMax = new int[n];
        // int[] rightMax = new int[n];
        // leftMax[0] = height[0];
        // rightMax[n - 1] = height[n - 1];
        int ans = 0;
        // for(int i = 1; i < n; i++){
        //     leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        //     rightMax[n - i + 1] = Math.max(rightMax[n - i], height[n - i + 1]);
        // }
        // for(int i = 0; i < n; i++){
        //     ans = ans + (Math.min(rightMax[i],leftMax[i]) - height[i]);
        // }
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                ans = ans + (leftMax - height[left]);
                left++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                ans = ans + (rightMax - height[right]);
                right--;
            }
        }
        return ans;
    }
}