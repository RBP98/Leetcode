class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        } 

        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int temp = queue.poll();
            numCourses--;
            for(int i: adj.get(temp)){
                indegree[i]--;
                if(indegree[i]==0){
                    queue.add(i);
                }
            }
        }
    return numCourses == 0;
    }
}