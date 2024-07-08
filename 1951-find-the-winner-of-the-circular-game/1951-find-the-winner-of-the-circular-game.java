class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) queue.add(i);
        int count = 1;
        while(queue.size() > 1){
           
            if(count != k){
                queue.add(queue.poll());
                // System.out.println();

            }else{
                queue.poll();
                // System.out.println("Remove " + queue.poll());
                count = 0;
            }
            count++;


        }
        // System.out.println(queue.size());
        return queue.poll();
    }
}