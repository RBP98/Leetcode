class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        List<Integer> list = new ArrayList<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if(bucket[value] == null){
                bucket[value] = new ArrayList<Integer>();
            }

            bucket[value].add(key);
        }

        for(int i = bucket.length - 1; i >=0; i--){
            if(bucket[i] != null){
                for(int j: bucket[i]){
                    list.add(j);
                    k--;
                    if(k == 0){
                        return list.stream().mapToInt(Integer::intValue).toArray();
                    }
                }
        
                    
            }
            
        }
        return new int[]{};
    }
}