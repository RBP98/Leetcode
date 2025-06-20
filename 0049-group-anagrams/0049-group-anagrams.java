class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            
            int arr[] = new int[26];
            for(int i = 0; i < s.length(); i++){
                arr[s.charAt(i) - 'a']++; 
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                sb.append(arr[i] - '0');
                sb.append("#");
            }

            String key = sb.toString();
            List<String> temp = new ArrayList<>();
            if(map.containsKey(key)){
                temp = map.get(key);
            }  
            temp.add(s); 
            map.put(key, temp);            


        }

    return new ArrayList<>(map.values());
    }
}