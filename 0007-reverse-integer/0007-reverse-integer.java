class Solution {
    public int reverse(int x) {
        boolean neg = false;
        int absx = Math.abs(x);
        if(x < 0){
            neg = true;
        }
        long y = 0;
        while(absx != 0){
            y = y * 10 + absx % 10;
            absx = absx/10;
        }
        if(neg == true){
            y = y * -1;
        }
        if(y > Integer.MAX_VALUE || y < Integer.MIN_VALUE){
            y = 0;
        }
        return (int)y;
        
    }
}