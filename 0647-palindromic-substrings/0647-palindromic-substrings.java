class Solution {
    public int countSubstrings(String s) {
        int result = 0;

        for(int i = 0; i < s.length(); i++){
            result = result + expand(s, i, i);
            result = result + expand(s, i, i + 1);
        }

        return result;
    }

    private int expand(String s,int low, int high){
        int ans = 0;
        while(low >= 0 && high < s.length()){
            if(s.charAt(low) != s.charAt(high)){
                break;
            }
            low--;
            high++;
            ans++;
        }
        return ans;
    }
}