class Solution {
    public int maxArea(int[] height) {
        // left and right
        int left = 0;
        int right = height.length - 1;

        int max = Integer.MIN_VALUE;
        // max  = Int_MIN
        //while left < right
        while(left < right){
            int area = 0;
            if(height[left] < height[right]){
                area = height[left] * (right - left);
                left++;
            }else{
                area = height[right] * (right - left);
                right--;
            }
        max = Math.max(area, max);
        }
        // max = Max(max, Min(height[left], height[right]))


        return max;
        //
    }
}