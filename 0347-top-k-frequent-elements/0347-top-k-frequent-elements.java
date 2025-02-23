class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        ArrayList<Integer>[] arrayOfLists = new ArrayList[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(arrayOfLists[value] == null){
                arrayOfLists[value] = new ArrayList<Integer>();
            }
            arrayOfLists[value].add(key);
        }
        int[] result = new int[k];
        for(int i = arrayOfLists.length - 1; i >= 0; i--){
            if(arrayOfLists[i] != null){
                for(int j: arrayOfLists[i]){
                    
                    if(k == 0){
                        return result;
                    }
                    result[--k] = j;
                    
                }
            }
        }
        return result;
    }
}