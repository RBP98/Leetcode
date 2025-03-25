class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int output[] = new int[n];

        String[] first = logs.get(0).split(":");
        
        stack.push(Integer.parseInt(first[0]));
        int prevTime = Integer.parseInt(first[2]);

        for(int i = 1; i < logs.size(); i++){
            String[] s = logs.get(i).split(":");

            int curr = Integer.parseInt(s[0]);
            int currTime = Integer.parseInt(s[2]);
         
            if(s[1].equals("start")){
                if(!stack.isEmpty()){
                    output[stack.peek()] = output[stack.peek()] + currTime - prevTime;
                }
                stack.push(curr);
                prevTime = currTime;
            }else{
                output[curr] = output[curr] + currTime - prevTime + 1;
                stack.pop();
                prevTime = currTime + 1;

            }
        }
        return output;
    }
}