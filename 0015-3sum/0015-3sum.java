class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] + nums[i] == 0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    set.add(temp);
                    left++;
                    right--;
                }else if(nums[left] + nums[right] + nums[i] < 0){
                    left++;
                }else{
                    right--;
                }
            }
            
        }

        for(List<Integer> s: set){
            output.add(s);
        }


    return output;
    }
}