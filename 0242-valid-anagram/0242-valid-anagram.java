class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            if(!map.containsKey(t.charAt(i))){
                return false;
            }
            else{
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }

        for(int i : map.values()){
            if(i != 0){
                return false;
            }
        }

        return true;
    }
}