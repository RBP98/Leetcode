class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> output = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] lists = new List[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(lists[value] == null){
                List<Integer> temp = new ArrayList<>();
                lists[value] = temp;   
            }
            (lists[value]).add(key);
        }

        for(int i = lists.length - 1; i >= 0; i--){
            if(lists[i] != null){
                for(int a: lists[i]){
                    output.add(a);
                }
            }
            if(output.size() == k){
                break;
            }
        }
    return output.stream().mapToInt(Integer::intValue).toArray();

    }
}