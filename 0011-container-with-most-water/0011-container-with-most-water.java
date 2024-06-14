class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r){ 
            maxArea = Math.max(maxArea, height[l] < height[r] ? height[l] * (r-l): height[r] * (r-l) );
            if(height[l] < height[r]) 
                l++;
            else 
                r--;
        }
    return maxArea;
    }
}