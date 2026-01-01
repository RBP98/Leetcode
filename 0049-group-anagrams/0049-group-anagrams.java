class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] freqMap = new char[26];
            for(char c: str.toCharArray()){
                freqMap[c - 'a']++; 
            }
            String key = String.valueOf(freqMap);

            List<String> temp = new ArrayList<>();
            if(map.containsKey(key)){
                temp = map.get(key);
            }
            temp.add(str);
            map.put(key, temp);

        }
        return new ArrayList(map.values());
    }
}