class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        
        for(List<String> ticket: tickets){
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).offer(ticket.get(1));
        }

        dfs("JFK");
        return result;
    }

    private void dfs(String s){
        PriorityQueue<String> dest = map.get(s);
        while(dest != null && !dest.isEmpty()){
            dfs(dest.poll());
        }
        result.addFirst(s);
    }
}