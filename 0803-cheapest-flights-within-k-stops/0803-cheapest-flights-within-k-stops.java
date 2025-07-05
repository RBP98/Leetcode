class Tuple{
    int node, cost, stops;
    public Tuple(int node, int cost, int stops){
        this.node = node;
        this.stops = stops;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Tuple>> adj = new HashMap<>();
        for(int[] flight: flights){
            adj.putIfAbsent(flight[0], new ArrayList<Tuple>());
            adj.get(flight[0]).add(new Tuple(flight[1], flight[2], 0));
        }

        Queue<Tuple> queue = new PriorityQueue<>((a,b) -> Integer.compare(a.cost, b.cost));
        queue.add(new Tuple(src, 0, 0));

        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        while(!queue.isEmpty()){
            Tuple temp = queue.poll();
            int node = temp.node;
            int cost = temp.cost;
            int stops = temp.stops;

            
            if(node == dst) return cost;

            if(stops > k || stops >= minStops[node]) continue;
            minStops[node] = stops;


            if(!adj.containsKey(node)) continue;
            for(Tuple neighbor: adj.get(node)){
                queue.add(new Tuple(neighbor.node, cost + neighbor.cost, stops + 1));
            }
        }
        return -1;
    }
}