class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            String stringHash = createHash(str);
            map.computeIfAbsent(stringHash, e -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String createHash(String str){
        char arr[] = new char[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length();i++){
            arr[str.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            sb.append(arr[i]).append("#");
        }
        return sb.toString();
    } 
}