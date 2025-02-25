class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = numCourses;

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[numCourses];

        for(List<Integer> i: adj){
            for(int j: i){
                indegree[j]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int[] arr = new int[numCourses];
        int count = 0;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            arr[numCourses - count - 1] = temp;
            n--;
            for(int i: adj.get(temp)){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
            count++; 
        }



    return n == 0 ? arr: new int[]{};
    }
}