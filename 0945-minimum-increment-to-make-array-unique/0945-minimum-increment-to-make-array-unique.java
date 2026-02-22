class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int moves = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] >= nums[i]){
                int tempMoves = nums[i - 1] - nums[i] + 1;
                moves = moves + tempMoves;

                nums[i] = nums[i - 1] + 1;
            }
        }
        return moves;
    }
}
// i = 1
// i       [0 1 2 3 4 5]
// nums[i] [1 1 2 2 3 7]
// moves = 0;