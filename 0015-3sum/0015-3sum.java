class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0){
                if(i == 0 || nums[i - 1] != nums[i]){
                    int left = i + 1;
                    int right  = nums.length - 1;
                    while(left < right){
                        int sum = nums[i] + nums[left] + nums[right];
                        if(sum < 0) left++;
                        else if(sum > 0) right--;
                        else{
                            list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                            left++;
                            right--;

                            while (left < right && nums[left] == nums[left - 1]) {
                                left++;
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
}