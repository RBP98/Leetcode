class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

         List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(entry.getKey());
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = nums.length; i >= 0 && resultList.size() < k; i--) {
            if (bucket[i] != null) {
                resultList.addAll(bucket[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = resultList.get(i);
        }

        // PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (map.get(b)) - (map.get(a)));
        // for(int i: map.keySet())
        //     pq.add(i);

        // int res[] = new int[k];
        // for(int i =0 ; i < k; i++){
        //     res[i] = pq.poll();
        // }

    return res;
    }
}