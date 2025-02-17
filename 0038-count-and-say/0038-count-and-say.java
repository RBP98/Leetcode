class Solution {
    public String countAndSay(int n) {
        StringBuilder ans = new StringBuilder();
        ans.append("1");
        for(int i = 1; i < n; i++) {
            ans = RLE(ans);
        }
        return ans.reverse().toString();
    }

    private StringBuilder RLE(StringBuilder s){
        int i = 0;
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()){
            int groupLength = 1;
            while(i + groupLength < s.length() && s.charAt(i) == s.charAt(i + groupLength)){
                groupLength++;
            }
            sb.append(s.charAt(i));
            sb.append(Integer.toString(groupLength));

            i = i + groupLength;
        }
        return sb;
    }
}