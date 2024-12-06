class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while(left < right){
            int rem = target - numbers[right];
            if(rem == numbers[left]) return new int[]{left + 1, right + 1};
            else if(rem > numbers[left])left++;
            else{
                right--;
            }
        }

    return new int[]{};
    }
}