class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //Init two ptrs one in e tsrta one in end of array

        int left = 0;
        int right = numbers.length - 1;
        //while num At right  > target then right--;
        // while(numbers[right] > target){
        //     right--;
        // }
        while(left < right){
            // while left < right
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left + 1, right + 1};
            }else if(sum > target){
                right--;
            }else{
                left++;
            }
            // num AT Left  + num AT right  == target
                // return 
            // else if sum > target right--
            //else left ++;

        }
        return new int[]{};
        //return  
            
    }
}