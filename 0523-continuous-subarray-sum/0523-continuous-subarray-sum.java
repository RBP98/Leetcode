class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){

            prefix = (prefix + nums[i])%k ;

            if(!map.containsKey(prefix)){
                map.put(prefix, i);
            }else{
                if(i - map.get(prefix) > 1){
                    return true;
                }
            }
        }

        return false;
    }
}