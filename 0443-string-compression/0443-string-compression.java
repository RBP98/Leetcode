class Solution {
    public int compress(char[] chars) {
        int ans = 0;
        int i = 0;
        while(i < chars.length){
            int groupLength = 1;
            char curr = chars[i];
            while(i + groupLength < chars.length && chars[i + groupLength] == curr){
                groupLength++;
            }
            chars[ans] = curr;
            ans++;
            if(groupLength > 1){
                for(char c: Integer.toString(groupLength).toCharArray()){
                    chars[ans] = c;
                    ans++;
                }
            }
            i = i + groupLength;
        }
        return ans;
    }
}