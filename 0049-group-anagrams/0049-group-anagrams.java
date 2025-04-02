class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // strs = ["eat","tea","tan","ate","nat","bat"]
        Map<String, List<String>> map= new HashMap<>();
        for(String s: strs){
            int[] key = new int[26];
            StringBuilder sb = new StringBuilder();
            for(char c: s.toCharArray()){
                key[c - 'a']++;
            }
            for(int i : key){
                sb.append("#").append(i);
            }
            String keyStr = sb.toString();
            List<String> tempList = new ArrayList<String>();
            if(map.containsKey(keyStr)){
                tempList = map.get(keyStr);
            }
            tempList.add(s);
            map.put(keyStr, tempList);
            
        }
    return new ArrayList<>(map.values());
    }
}