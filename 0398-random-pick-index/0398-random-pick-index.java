class Solution {

    Map<Integer, List<Integer>> map;
    public Solution(int[] nums) {
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<Integer>());
            }
            List<Integer> temp = map.get(nums[i]);
            temp.add(i);
            map.put(nums[i], temp);    
        }
        
    }
    
    public int pick(int target) {
        Random random = new Random();
        int size = map.get(target).size();
        return map.get(target).get(random.nextInt(size));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */