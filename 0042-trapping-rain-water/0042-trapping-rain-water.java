class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int trappedWater = 0;
        while(left < right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            
            if(height[left] < height[right]){
                trappedWater = trappedWater + (leftMax - height[left]);
                left++;
            }else{
                trappedWater = trappedWater + (rightMax - height[right]);
                right--;
            }
        }
        return trappedWater;
    }
}