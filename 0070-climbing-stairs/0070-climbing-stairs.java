class Solution {
    public int climbStairs(int n) {
         int num1 = 0;
         int num2 = 1;
         int res = 0;
         
         for(int i = 0; i < n; i++){
            res = num1 + num2;
            num1 = num2;
            num2 = res;
         }

         return res;
    }
}