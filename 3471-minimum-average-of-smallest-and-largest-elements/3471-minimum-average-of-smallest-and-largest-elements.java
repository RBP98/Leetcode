class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        double minAvg = Double.MAX_VALUE;
        double avg = 0.0;
        while(i < j){
            avg = (nums[i] + nums[j])/2.0;
            if(avg < minAvg) minAvg = avg;
            i++;
            j--;
        }
    return minAvg;
    }
}