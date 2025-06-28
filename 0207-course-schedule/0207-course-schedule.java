class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<Integer>());
        }
        for(int[] p : prerequisites){
            list.get(p[1]).add(p[0]);
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < list.size(); i++){
            for(int j : list.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);        
            }
        }

        while(!queue.isEmpty()){
            int val = queue.poll();
            numCourses--;
            for(int i: list.get(val)){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }


        }
        return numCourses == 0;
        
    }
}