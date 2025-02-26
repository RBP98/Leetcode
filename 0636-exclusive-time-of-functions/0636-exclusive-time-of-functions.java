class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        String[] first = logs.get(0).split(":");
        
        stack.push(Integer.parseInt(first[0]));
        int prev = Integer.parseInt(first[2]);
        int res[] = new int[n];
        
        for(int i = 1; i < logs.size(); i++){
            String[] s = logs.get(i).split(":");
            int currFunc = Integer.parseInt(s[0]);
            int currTime = Integer.parseInt(s[2]);
            if(s[1].equals("start")){
                if(!stack.isEmpty()) 
                    res[stack.peek()] += currTime - prev;
                stack.push(currFunc);
                prev = currTime; 
            }else{
                res[stack.peek()] += currTime - prev + 1;
                stack.pop();
                prev = currTime + 1;
            }
        }
        return res;
    }
}