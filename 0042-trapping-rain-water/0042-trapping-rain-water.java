class Solution {
    public int trap(int[] height) {
        int[] preMax = new int[height.length];
        int[] sufMax = new int[height.length];
        preMax[0] = height[0];
        for(int i = 1;i < height.length; i++){
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }
        sufMax[height.length - 1] = height[height.length - 1];
       
        for(int i = height.length - 2; i >= 0; i--){
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }
        int sum = 0;
        for(int i = 0; i < height.length; i++) {
            sum = sum + Math.max(0, (Math.min(preMax[i], sufMax[i]) - height[i]));
        }        
        return sum;
    }
}