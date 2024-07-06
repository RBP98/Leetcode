class Solution {
    public int passThePillow(int n, int time) {
        int div = time/(n-1);
        int mod = time%(n-1);
        int ans = 0;
        if(div % 2 != 0){
            ans = n - mod;
        }else{
            ans = mod + 1;
        }
        return ans;
    }
}