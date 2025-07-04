class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Tuple>> map = new HashMap<>();
        for(int[] flight: flights){
            int source = flight[0];
            int dest = flight[1];
            int cost = flight[2];

            map.putIfAbsent(source, new ArrayList<>());
            map.get(source).add(new Tuple(flight[1], flight[2], 0));
        }
        
        Queue<Tuple> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        queue.add(new Tuple(src, 0, k + 1));

        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int node = t.node;
            int cost = t.cost;
            int stopsRemaining = t.stops;

            if(node == dst) return cost;

            if(stopsRemaining > 0){

                if (stopsRemaining <= minStops[node] && minStops[node] != Integer.MAX_VALUE) continue;
                minStops[node] = stopsRemaining;

                if(map.containsKey(node)){
                    for(Tuple neighbor: map.get(node)){
                        int nextNode = neighbor.node;
                        int costToNext = neighbor.cost;
                        queue.add(new Tuple(nextNode, cost + costToNext, stopsRemaining -1));
                    }
                }
            }
        }
        return -1;
    }
}
class Tuple{
    int node;
    int cost;
    int stops;
    public Tuple(int node, int cost, int stops){
        this.node = node;
        this.cost = cost;
        this.stops = stops;
    }
}