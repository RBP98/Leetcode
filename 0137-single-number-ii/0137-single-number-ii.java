class Solution {
    public int singleNumber(int[] nums) {
        Set<Long> set = new HashSet<>();
        long sumOfSet = 0;
        long sumOfNums = 0;
        for(int i : nums){
            set.add((long)i);
            sumOfNums = sumOfNums + i; 
        }
        for(long i : set){
            sumOfSet = sumOfSet + i;
        }

        return (int)(((3 * sumOfSet)  - sumOfNums)/2);

    }
}