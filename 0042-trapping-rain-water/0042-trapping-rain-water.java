class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int maxLeft = height[0];
        int water[] = new int[n];
        for(int i = 1; i < n; i++){
            leftMax[i]=Math.max(maxLeft, height[i - 1]);
            maxLeft = leftMax[i];
        }
        int maxRight = height[n-1];
        for(int i = n-2; i >= 0; i--){
            rightMax[i] = Math.max(maxRight, height[i + 1]);
            maxRight = rightMax[i];
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            water[i] = Math.max(0, Math.min(rightMax[i], leftMax[i]) - height[i]);
            sum = sum + water[i];

        }
        
        
        return sum;
    }
}