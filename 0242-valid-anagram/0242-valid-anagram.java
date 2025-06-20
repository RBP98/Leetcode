class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        } 

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
            }else{
                return false;
            }
        }

        for(int i: map.values()){
            if(i != 0){
                return false;
            }
        }

        return true;
    }
}