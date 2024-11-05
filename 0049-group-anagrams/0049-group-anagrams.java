class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            List<String> list = new ArrayList<>();
            if(map.containsKey(sorted)){
                list = map.get(sorted);    
            }
            list.add(s);
            map.put(sorted, list);
        }
        return new ArrayList<>(map.values());
    }
}

       

