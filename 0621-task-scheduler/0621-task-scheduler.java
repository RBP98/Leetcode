class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freqMap[] = new int[26];
        for(char c: tasks) freqMap[c - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : freqMap) 
            if(i != 0){
                pq.add(i);
            }
            
        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !cooldown.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int count = pq.poll() - 1;
                if(count > 0){
                    cooldown.add(new int[]{time + n, count});
                }
            }

            if(!cooldown.isEmpty() && cooldown.peek()[0] == time){
                pq.add(cooldown.poll()[1]);
            }
        }
        return time;
    }
}