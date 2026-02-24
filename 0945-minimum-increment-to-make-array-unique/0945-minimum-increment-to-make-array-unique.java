class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i - 1]){
                int tempMoves = nums[i - 1] - nums[i] + 1;
                moves = moves + tempMoves;

                nums[i] = nums[i - 1] + 1;
            }
        }

        return moves;
    }
}