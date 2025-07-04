class Pair{
    int time, node;
    public Pair(int time, int node){
        this.time = time;
        this.node = node;
    }
}

class Solution {
    Map<Integer, List<Pair>> adj = new HashMap<>();
  
    private void dijkstra(int[] signalReceivedAt, int source, int n){
        Queue<Pair> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        
        queue.add(new Pair(0, source));
        signalReceivedAt[source] = 0;
        
        while(!queue.isEmpty()){
            
            Pair p = queue.poll();
            int currNodeTime = p.time;
            int currNode = p.node;

            if (currNodeTime > signalReceivedAt[currNode]) {
                continue;
            }
            
            if (!adj.containsKey(currNode)) {
                continue;
            }

            for(Pair neighbor: adj.get(currNode)){
                int time = neighbor.time;
                int node = neighbor.node;

                if(signalReceivedAt[node] > currNodeTime + time){
                    signalReceivedAt[node] = currNodeTime + time;
                    queue.add(new Pair(signalReceivedAt[node], node));
                }
            }

        }
    } 

    public int networkDelayTime(int[][] times, int n, int k) {
        for(int[] time: times){
            int source = time[0];
            int dest = time[1];
            int weight = time[2];

            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(weight, dest)); 
        }

        int[] signalReceivedAt = new int[n + 1];

        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        dijkstra(signalReceivedAt, k, n);
        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            answer = Math.max(answer, signalReceivedAt[i]);    
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;


    }
}