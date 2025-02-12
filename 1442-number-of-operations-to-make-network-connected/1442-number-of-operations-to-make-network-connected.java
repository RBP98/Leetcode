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

    public boolean connectionExists(int a, int b){
        return findParent(a) == findParent(b);
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
        int parentOfA = findParent(a);
        int parentOfB = findParent(b);

        if(parentOfA == parentOfB) return;
        if(size.get(parentOfA) < size.get(parentOfB)){
            parent.set(parentOfA, parentOfB);
            size.set(parentOfB, size.get(parentOfA) + size.get(parentOfB));
        }else{
            parent.set(parentOfB, parentOfA);
            size.set(parentOfA, size.get(parentOfA) + size.get(parentOfB));
        }
        
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraConn = 0;
        if(n > connections.length + 1){
            return -1;
        }
        for(int i = 0; i < connections.length; i++){
            if(ds.connectionExists(connections[i][0], connections[i][1])){
                extraConn++;
            }else{
                ds.union(connections[i][0], connections[i][1]);
            }
            
        }
        int count = -1;
        for(int i = 0; i < ds.parent.size(); i++){
            if(ds.parent.get(i) == i){
                count++;
            }
        }

        System.out.println(count);
        System.out.println(extraConn);
        
    return extraConn >= count ? count : -1;
    }
}