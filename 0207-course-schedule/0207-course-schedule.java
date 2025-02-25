class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // for(List<Integer> a: adj){
        //     System.out.println(a);
        // }

        // for(int i : indegree){
        //     System.out.println(i + " ");
        // }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            for(int j: adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
                
                // for(int j: adj.get(i)){
                //     indegree[j]--;
                // }
                
            }
        }

        while(!queue.isEmpty()){
            int val = queue.poll();
            for(int j: adj.get(val)){
                indegree[j]--;
                if(indegree[j] == 0){
                    queue.add(j);
                }
            }
        }

        for(int i : indegree){
            if( i != 0) return false;
            // System.out.println(i + " ");
        }

        

        return true;
    }
}