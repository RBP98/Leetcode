class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        
        int left = 0;
        int right = height.length - 1;
        for(int i : height){
          
            int area = Math.min(height[left], height[right]) * (right - left);

            max = Math.max(area, max);
            if(height[left] > height[right])
                right--;
            else
                left++;
        }

        return max;
    }
}