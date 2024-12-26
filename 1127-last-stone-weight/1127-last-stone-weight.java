class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int i: stones) maxHeap.offer(i);
        while(maxHeap.size() > 1) {
            int w1 = maxHeap.poll();
            int w2 = maxHeap.poll();
            int diff = w1-w2;
            if(diff != 0) {
                maxHeap.offer(diff);
            }
        }
        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}