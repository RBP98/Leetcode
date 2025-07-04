class Solution {
    private int find(int[] parent, int node){
        if(parent[node] == node) return node;
        return parent[node] = find(parent, parent[node]);
    }
    
    private boolean union(int a, int b, int[] parent, int[] size){
        a = find(parent, a);
        b = find(parent, b);

        if(a == b) return false;

        if(size[a] > size[b]){
            size[a] = size[a] + size[b];
            parent[b] = parent[a];
        }else{
            size[b] = size[b] + size[a];
            parent[a] = parent[b];
        }

        return true;

    } 

    public int[] findRedundantConnection(int[][] edges) {
        int parent[] = new int[edges.length + 1];
        int size[] = new int[edges.length + 1];

        for(int i = 1; i <= edges.length; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int i = 0; i < edges.length; i++){
            if(!union(edges[i][0], edges[i][1], parent, size)){
                return new int[]{edges[i][0], edges[i][1]};
            }
        }
        return new int[]{};
    }
}