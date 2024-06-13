class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            for(int j: adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        int[] res = new int[numCourses];
        while(!queue.isEmpty()){
            int temp = queue.poll();
            res[count] = temp;
            numCourses--;
            for(int node: adj.get(temp)){
                indegree[node]--;
                if(indegree[node] == 0){
                    queue.add(node);
                }
            }
            count++;
        }

    return numCourses == 0 ? res: new int[]{};
    }
}