class DisjointSet{
    List<Integer> parent;
    List<Integer> size;

    public DisjointSet(int n){
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
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
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        int connectedComps = n;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isConnected[i][j] == 1 && ds.findParent(i) != ds.findParent(j)){
                    ds.union(i, j);
                    connectedComps--;
                }
            }
        }
        // for(int i = 1; i < ds.parent.size(); i++){
        //     if(ds.parent.get(i) == i){
        //         count++;
        //     }
        // }
        return connectedComps;
    }
}