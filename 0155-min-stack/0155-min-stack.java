class MinStack {

    Stack<Integer> stack;
    Stack<Integer> supportStack;
    public MinStack() {
        stack = new Stack<>();
        supportStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(supportStack.isEmpty() || supportStack.peek() >= val){
            supportStack.push(val);
        }
        
    }
    
    public void pop() {
        
      
        if(supportStack.peek().equals(stack.peek())){
            supportStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return supportStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */