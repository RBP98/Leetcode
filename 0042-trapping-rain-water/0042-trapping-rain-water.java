class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int res = 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        while(left < right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if(height[left] < height[right]){    
                res = res + (leftMax - height[left]);
                left++;
            }else{
                res = res + (rightMax - height[right]);
                right--;
            }
        }
        return res;
    }
}