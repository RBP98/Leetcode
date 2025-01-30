class Solution {
    public List<String> generateParenthesis(int n) {
        int open= n, close = n;
        List<String> output = new ArrayList<>();
        String s = "";
        generateP(open, close, s, output);
        return output;
    }

    private void generateP(int open, int close, String s, List<String> list){
        if(open == 0 && close == 0) list.add(s);

        if(open != 0){
            StringBuilder sb = new StringBuilder(s);
            sb.append("(");
            generateP(open - 1, close, sb.toString(), list);
        }

        if(open != close){
            StringBuilder sb = new StringBuilder(s);
            sb.append(")");
            generateP(open, close - 1, sb.toString(), list);
        }
    }
}