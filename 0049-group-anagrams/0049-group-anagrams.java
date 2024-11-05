class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if(!map.containsKey(sorted)){
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted, list); 
            }else{
                List<String> list = map.get(sorted);
                list.add(s);
                map.put(sorted, list);
            }


        }
        return new ArrayList<List<String>>(map.values());
    }
}