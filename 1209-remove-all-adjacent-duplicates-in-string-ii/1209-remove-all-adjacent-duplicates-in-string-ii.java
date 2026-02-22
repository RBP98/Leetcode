class Pair{
    char letter;
    int count;
    public Pair(char letter, int count){
        this.letter = letter;
        this.count = count;
    }

}

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<Pair>();
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && stack.peek().letter == c){
                stack.peek().count++;
            }else{
                stack.push(new Pair(c, 1));
            }

            if(stack.peek().count == k){
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Pair p: stack) sb.append(String.valueOf(p.letter).repeat(p.count));

        return sb.toString();
    }
}