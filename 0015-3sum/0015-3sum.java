class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        // Sort the array
        Arrays.sort(nums);
        //iterate thrpugh array once

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                // int sum = nums[left] + nums[right] + nums[i];
                if(nums[left] + nums[right] + nums[i] == 0){
                    List<Integer> temp = List.of(nums[i], nums[left], nums[right]);
                    list.add(temp);
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }

                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(nums[left] + nums[right] + nums[i] > 0){
                    // while(left < right && nums[left] + nums[right] + nums[i] > 0){
                        right--;
                    // }
                }else{
                    // while(left < right && nums[left] + nums[right] + nums[i] < 0){
                        left++;
                    // }
                }
            }
        }
        return list;
    }
}