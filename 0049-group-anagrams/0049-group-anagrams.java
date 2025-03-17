class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            String stringHash = createHash(str);
            System.out.println(stringHash);
            map.computeIfAbsent(stringHash, e -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String createHash(String str){
        char arr[] = new char[26];
        for(int i = 0; i < str.length();i++){
            arr[str.charAt(i) - 'a']++;
        }

        // for(char i: arr){
        //     System.out.print((i) + " ");
        // }
        return String.valueOf(arr);
    } 
}