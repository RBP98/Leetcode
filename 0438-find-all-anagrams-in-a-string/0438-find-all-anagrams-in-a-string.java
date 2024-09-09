class Solution {

     public boolean isAnagram(char[] map, String window){
        // Map<Character, Integer> windowMap = new HashMap<>();
        // for(int i = 0; i < window.length(); i++){
        //     windowMap.put(window.charAt(i), windowMap.getOrDefault(window.charAt(i), 0) + 1);
        // }

        char[] windowMap = new char[26];
        for(int i = 0; i < window.length(); i++){
            char c = window.charAt(i);
            windowMap[c - 'a']++; 
        }
        for(int i = 0; i < windowMap.length; i++){
            if(map[i] != windowMap[i]) 
                return false;
        }
        // for(char c : windowMap.keySet()){
        //     if(map.get(c) != windowMap.get(c)){
        //         return false;
        //     }
        // }
        
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        // Map<Character, Integer> map = new HashMap<>();
        // for(int i = 0; i < p.length(); i++){
        //     map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        // }
        char[] map = new char[26];
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map[c - 'a']++; 
        }

        int j = p.length();
        int i = 0;
        while(j <= s.length()){
            if(isAnagram(map, s.substring(i, j))){
                list.add(i);
            }
            i++;
            j++;
        }
        return list;
    }
}