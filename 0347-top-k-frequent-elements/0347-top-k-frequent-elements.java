class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // int maxValue = 0;
        int maxFreq = 0;
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i: nums){
            int temp = map.getOrDefault(i, 0) + 1;
            map.put(i, temp);
            maxFreq = Math.max(maxFreq, temp);
            // maxValue = Math.max(maxValue, i);
        }
        System.out.println(maxFreq);

        ArrayList<Integer> buckets[] = new ArrayList[maxFreq + 1];

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if(buckets[value] == null){
                buckets[value] = new ArrayList<>();   
            }
            buckets[value].add(key);

        }
        int[] res = new int[k];
        int count = 0;
        for(int i = buckets.length - 1; i > 0; i--){
            if(buckets[i] != null){
                for(int j: buckets[i]){
                    if(count == k){
                        break;
                    }
                    res[count++] = j;
                }
            }
        }

        return res;

    }
}