class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        // int prefix[] = new int[nums.length + 1];
        // prefix[0] = 0;
        // for(int i = 1; i <= nums.length; i++){
        //     prefix[i] = prefix[i - 1] + nums[i - 1];
        // }

        for(int i = 0; i < nums.length; i++){
            int sum = 0;
       
            for(int j = i; j < nums.length; j++){

                sum = sum + nums[j];
                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }
}