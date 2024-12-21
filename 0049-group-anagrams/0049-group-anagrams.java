class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            List<String> temp = new ArrayList<>();
            if(map.containsKey(sorted)){
                temp = map.get(sorted);
            }
            temp.add(str);
            map.put(sorted, temp);
        }
        return new ArrayList<>(map.values());
    }
}