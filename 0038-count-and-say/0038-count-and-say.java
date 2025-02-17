class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for(int i = 1; i < n; i++) {
            ans = RLE(ans);
        }
        return ans;
    }

    private String RLE(String s){
        int i = 0;
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()){
            int groupLength = 1;
            while(i + groupLength < s.length() && s.charAt(i) == s.charAt(i + groupLength)){
                groupLength++;
            }
            sb.append(groupLength);
            sb.append(s.charAt(i));
      
            i = i + groupLength;
        }
        return sb.toString();
    }
}