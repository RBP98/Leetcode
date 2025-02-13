class DisjointSet{
    List<Integer> parent;
    List<Integer> size;

    public DisjointSet(int n){
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i = 0; i < n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int grandParent = findParent(parent.get(node));
        parent.set(node, grandParent);
        return grandParent;
    }

    public void union(int a, int b){
        int aPar = findParent(a);
        int bPar = findParent(b);

        if(aPar == bPar) return;
        if(size.get(aPar) < size.get(bPar)){
            parent.set(aPar, bPar);
            size.set(bPar, size.get(aPar) + size.get(bPar));
        }else{
            parent.set(bPar, aPar);
            size.set(aPar, size.get(aPar) + size.get(bPar));
        } 
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(n);
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(!map.containsKey(email)){
                    map.put(email, i);
                }else{
                    ds.union(map.get(email), i);
                }
                
            }
        }

        ArrayList<String>[] merged  = new ArrayList[n]; 

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            int root = ds.findParent(value);
            if(merged[root] == null){
                merged[root] = new ArrayList<>();
            }
            merged[root].add(key);
        }

        List<List<String>> output = new ArrayList<>(); 
        for(int i = 0; i < n; i++){
            if(merged[i] != null){
                String name = accounts.get(i).get(0);
                List<String> temp = new ArrayList<>();
                temp.add(name);
                Collections.sort(merged[i]);
                for(int j = 0; j < merged[i].size(); j++){
                    temp.add(merged[i].get(j));
                }
                output.add(temp);
            }
            
        }

        return output;
    }
}