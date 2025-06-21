class Solution {
    
    // {1: 3, 2: 5, 3: 2, 6: 4}
    // [3, ]

    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int minFreq = Integer.MAX_VALUE;
        int maxFreq = Integer.MIN_VALUE;
        
        // for(int i : nums){
        //     minNum  = Math.min(minNum, i);
        //     maxNum  = Math.max(maxNum, i);
        // }
        
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
            minFreq = Math.min(minFreq, map.get(i));
            maxFreq = Math.max(maxFreq, map.get(i));
        }

        ArrayList<Integer>[] arr = new ArrayList[maxFreq - minFreq + 1];

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if(arr[value - minFreq] == null){
                arr[value - minFreq] = new ArrayList<>();
            }

            arr[value - minFreq].add(key);

        }
        int count = 0;
        int res[] = new int[k];
        for(int i = arr.length - 1; i >= 0 && count < k; i--){
            if(arr[i] != null){
                for(int num: arr[i]){
                    
                    res[count] = num;
                    count++;
                    if(count == k){
                        break;
                    }
                    
                }
            }

        }

        return res;
    }
}