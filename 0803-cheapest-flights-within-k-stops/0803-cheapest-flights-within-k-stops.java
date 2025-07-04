public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Tuple>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>())
                .add(new Tuple(flight[1], flight[2], 0));
        }

        // Min-heap: (cost so far, current node, stops so far)
        PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new Tuple(src, 0, 0));

        // (node -> min stops seen so far)
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            Tuple current = pq.poll();
            int node = current.node;
            int cost = current.cost;
            int stops = current.stops;

            if (node == dst) return cost;

            if (stops > k || stops >= minStops[node]) continue;
            minStops[node] = stops;

            if (!graph.containsKey(node)) continue;
            for (Tuple neighbor : graph.get(node)) {
                pq.offer(new Tuple(neighbor.node, cost + neighbor.cost, stops + 1));
            }
        }

        return -1;
    }
}

class Tuple {
    int node, cost, stops;
    public Tuple(int node, int cost, int stops) {
        this.node = node;
        this.cost = cost;
        this.stops = stops;
    }
}
