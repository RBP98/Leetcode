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
        if(node == parent.get(node)) return node;
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
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int countOfOnes = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) continue;

                countOfOnes++;
                int[] drow = {0, 1, 0, -1};
                int[] dcol = {1, 0, -1, 0};

                for(int ind = 0; ind < 4; ind++){
                    int newRow = i + drow[ind];
                    int newCol = j + dcol[ind]; 
                    if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && grid[newRow][newCol] == 1){
                        int currNode = i * n + j;
                        int adjNode = newRow * n + newCol;

                        System.out.println(currNode);
                        System.out.println(adjNode);
                        ds.union(currNode, adjNode);
                    }
                }
            }
        }
        if(countOfOnes == n * n) return countOfOnes;
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) continue;
                int[] drow = {0, 1, 0, -1};
                int[] dcol = {1, 0, -1, 0};
                Set<Integer> components = new HashSet<>();
      
                for(int ind = 0; ind < 4; ind++){
                    int newRow = i + drow[ind];
                    int newCol = j + dcol[ind]; 
                    if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && grid[newRow][newCol] == 1){
                        int adjNode = newRow * n + newCol;
                        components.add(ds.findParent(adjNode));

                    }
                }
            int compSize = 1;
            for(int comp: components){
                compSize = compSize + ds.size.get(comp);
            }

            max = Math.max(max, compSize);

            }
        }

    return max;
    }
}