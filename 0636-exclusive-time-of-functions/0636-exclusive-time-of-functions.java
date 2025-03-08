class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        String[] first = logs.get(0).split(":");
        Stack<Integer> stack = new Stack<>();

        stack.push(Integer.parseInt(first[0]));
        int prevTime = Integer.parseInt(first[2]);
        int[] output = new int[n];
        for(int i = 1; i < logs.size(); i++){
            String[] currLog = logs.get(i).split(":");
            int currTime = Integer.parseInt(currLog[2]);
            int currID = Integer.parseInt(currLog[0]);

            if(currLog[1].equals("start")){
                if(!stack.isEmpty()){
                    output[stack.peek()] = output[stack.peek()] + currTime - prevTime;
                }
                stack.push(currID);
                prevTime = currTime;
            }else{
                output[currID] = output[currID] + currTime - prevTime + 1;
                if(!stack.isEmpty()){
                    stack.pop();
                }
                prevTime = currTime + 1;
            }
        }
        return output;
    }
}