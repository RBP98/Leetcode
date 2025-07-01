class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }

        for(int[] i : prerequisites){
            list.get(i[1]).add(i[0]);
        }

        int[] indegree = new int[numCourses];

        for(List<Integer> i: list){
            for(int j: i){
                indegree[j]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int val = queue.poll();
            res.add(val);
            numCourses--;
            for(int i : list.get(val)){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }


        }


        

        return numCourses != 0 ? new int[]{} : res.stream().mapToInt(Integer::intValue).toArray();
    }
}