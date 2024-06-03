class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0 ; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            for(int j: adj.get(i)){
                indegree[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int[] topo = new int[numCourses];
        int count = 0;
        
        while(!queue.isEmpty()){
            int temp = queue.poll();
            topo[count] = temp;
            numCourses--;
            for(int i : adj.get(temp)){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
        count++;
        }
    return numCourses == 0 ? topo: new int[]{};
    }
}