class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            result = result + expandAroundCenter(s, i, i);

            result = result + expandAroundCenter(s, i, i + 1);
        }

        return result;
    }

    private int expandAroundCenter(String str, int low, int high){
        int ans = 0;
        
        while(low >= 0 && high < str.length()){

            if(str.charAt(low) != str.charAt(high)){
                break;
            }

            low--;
            high++;

            ans++;
        }

        return ans;
    }
}