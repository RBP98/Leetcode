class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums[i], temp);
            }else{

                List<Integer> temp = new ArrayList<>();
                temp = map.get(nums[i]);
                for(int t: temp){
                    if(Math.abs(t - i) <= k){
                        return true;
                    }
                }
                temp.add(i);
                map.put(nums[i], temp);
            }
        }
        
    return false;
    }
}