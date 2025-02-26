class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = s.length();
        char last = s.charAt(n - 1);
        int total = map.get(last);

        for(int i = n - 2; i >= 0; i--){
            char curr = s.charAt(i);
            if(map.get(curr) < map.get(last)){
                total = total - map.get(curr);
            }else{
                total = total + map.get(curr);
            }
            last = curr;
        }
        return total;
    }
}