class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){

            if(i > 0 && nums[i - 1] == nums[i]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    list.add(temp);
                    while(left < right && nums[left] == nums[left + 1])
                        left++;
                    while(left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                        left++;  
                        
                }else{
                        right--;

                }
            }
            
        }

        return list;
    }
}