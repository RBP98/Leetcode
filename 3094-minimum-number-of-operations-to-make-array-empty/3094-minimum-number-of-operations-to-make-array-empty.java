class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = 0;
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int value = entry.getValue();
            if(value == 1) return -1;
            if(value%3 != 0){
                ans += 1;
            }
            ans += value/3;
        }
        return ans;
    }
}