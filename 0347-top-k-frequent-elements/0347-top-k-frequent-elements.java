class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
            max = Math.max(max, map.get(i));
        }

        List<Integer> freqArr[] = new ArrayList[max + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            List<Integer> temp = new ArrayList<>();
            if(freqArr[value] != null) 
                temp = freqArr[value];

            temp.add(key); 
            freqArr[value] = temp;
        }

        for(int i = freqArr.length - 1; i >= 0; i--){
            if(freqArr[i] != null){
                for(int j: freqArr[i]){
                    if(k == 0){
                        break;
                    }
                    list.add(j);
                    k--;
                }
            }   
            
            
        }
    return list.stream().mapToInt(Integer::intValue).toArray();
    }
}