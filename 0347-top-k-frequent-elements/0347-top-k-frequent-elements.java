class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for(int i: map.keySet()){
            pq.add(i);
            if(k < pq.size()){
                pq.poll();
            }
            
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            if(!pq.isEmpty()){
                res[i] = pq.poll();
            }

        }

    return res;
    }
}