class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
        int currentArea = 0;
            if(height[left] < height[right]){
                currentArea = (right - left)* height[left];
                left++; 
            }else{
                currentArea = (right - left)* height[right];
                right--;
            }
            maxArea = Math.max(currentArea, maxArea);
        }
        return maxArea;
    }
}