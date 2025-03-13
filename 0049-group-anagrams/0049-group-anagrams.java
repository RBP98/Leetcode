class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            String stringHash = createHash(str);
            List<String> temp = new ArrayList<>();
            if(map.containsKey(stringHash)){
                temp = map.get(stringHash);
            }
            temp.add(str);
            map.put(stringHash, temp);
        }
        return new ArrayList<>(map.values());
    }

    private String createHash(String str){
        char arr[] = new char[26];
        for(int i = 0; i < str.length();i++){
            arr[str.charAt(i) - 'a']++;
        }
        return new String(arr);
    } 
}