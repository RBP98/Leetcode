class Solution {
    public int maxPower(String s) {
        char lastChar = s.charAt(0);
        int power = 1;
        int currLength = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == lastChar){
                currLength++;
                continue;
            }
            power = Math.max(power, currLength);
            currLength = 1;
            lastChar = s.charAt(i);
        }

        power = Math.max(power, currLength);
        return power;
    }
}