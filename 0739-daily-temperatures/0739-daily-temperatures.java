class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Arrays.fill(answer, 0);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int temp = stack.pop();
                answer[temp] = i - temp;
            }
            stack.push(i);
        }
        return answer;
    }
}