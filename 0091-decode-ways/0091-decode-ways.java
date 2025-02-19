class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        return helper(0, s);
    }

    private int helper(int index, String s){
        if(map.containsKey(index)) return map.get(index);

        if(index == s.length()) return 1;

        if(s.charAt(index) == '0') return 0;
        
        if(index == s.length() - 1) return 1;

        int ans = helper(index + 1, s);

        if(Integer.parseInt(s.substring(index, index + 2)) <= 26){
            ans = ans + helper(index + 2, s);
        }
        map.put(index, ans);

        return ans;
    }
}