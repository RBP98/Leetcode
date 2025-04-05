class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        left = 0
        right = len(height) - 1
        leftMax = height[left]
        rightMax = height[right]
        total = 0

        while left < right:
            leftMax = max(leftMax, height[left])
            rightMax = max(rightMax, height[right])

            if leftMax < rightMax:
                total += leftMax - height[left]
                left += 1
            else:
                total += rightMax - height[right]
                right -= 1
        
        return total