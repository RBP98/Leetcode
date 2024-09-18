class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> out = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = i + 1; j < nums.length; j++){
                int third = -(nums[j] + nums[i]);
                if(set.contains(third)){
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], third));
                    Collections.sort(list);
                    out.add(list);
                }
                set.add(nums[j]); 
            }
        }
        return new ArrayList<>(out);
    }
}