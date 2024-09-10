class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> arr[] = new ArrayList[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int freq = entry.getValue();
            if(arr[freq]==null){
                arr[freq] = new ArrayList<>();
            }
            arr[freq].add(entry.getKey());
        }       
        int count = 0;
        int[] res = new int[k];
        for(int i = arr.length - 1; i > 0 ; i--){
            if(arr[i] != null){
                for(int j : arr[i])
                    res[count++] = j;
                    if(count == k){
                        return res;
                    }
            }
        }
        return res;
    }
}