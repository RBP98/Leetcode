class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int i: stones) maxHeap.offer(i);
        for(int i = 0; i < stones.length; i++){
            if(maxHeap.size() == 1){
                return maxHeap.poll();
            }
            int diff = maxHeap.poll() - maxHeap.poll();
            if(diff > 0){
                maxHeap.offer(diff);
            }
            if(maxHeap.size() == 0) return 0;
        }
    return 0;
    }
}