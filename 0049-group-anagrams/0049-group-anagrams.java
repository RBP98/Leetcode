class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            List<String> temp = new ArrayList<>();
            if(map.containsKey(sorted)){    
                temp = map.get(sorted);
            }
            temp.add(s);
            map.put(sorted, temp);
        }
        return new ArrayList<>(map.values());
    }
}