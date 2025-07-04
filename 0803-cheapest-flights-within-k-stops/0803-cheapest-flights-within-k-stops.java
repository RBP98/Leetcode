class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Tuple>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], cost = flight[2];
            graph.get(u).add(new Tuple(v, cost, 0));
        }

        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(src, 0, 0)); // node, cost, stops used

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            int node = current.node, cost = current.cost, stops = current.stops;

            if (stops > k) continue;

            if (graph.containsKey(node)) {
                for (Tuple neighbor : graph.get(node)) {
                    int next = neighbor.node;
                    int nextCost = neighbor.cost + cost;
                    if (nextCost < minCost[next]) {
                        minCost[next] = nextCost;
                        queue.offer(new Tuple(next, nextCost, stops + 1));
                    }
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}

class Tuple {
    int node;
    int cost;
    int stops;

    public Tuple(int node, int cost, int stops) {
        this.node = node;
        this.cost = cost;
        this.stops = stops;
    }
}
