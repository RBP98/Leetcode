class Solution {
    public int largestCombination(int[] candidates) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i: candidates){
            int position = 0;
            while(i != 0){
                if(i % 2 == 1){
                    map.put(position, map.getOrDefault(position, 0) + 1);
                }
                position++;
                i = i/2;
            }
        }
        int largestCombination = 0;
        for(int i: map.values()){
            largestCombination = Math.max(largestCombination, i);
        }

        return largestCombination;
    }
}