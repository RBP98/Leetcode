class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            List<Integer> temp = new ArrayList<>();
            if(map.containsKey(nums[i])){
                temp = map.get(nums[i]);
                for(int t: temp){
                    if(Math.abs(t - i) <= k){
                        return true;
                    }
                } 
            }
            temp.add(i);
            map.put(nums[i], temp);
        }
        
    return false;
    }
}