public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int power = 31;

        while(n != 0){
            res = res + ((n & 1) << power);
            n = n >>> 1;
            power = power - 1;
        }
        return res;
    }
}