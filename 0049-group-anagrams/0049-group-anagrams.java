class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            List<String> tempList = new ArrayList<>();
            if(!map.containsKey(sortedStr)){
                tempList.add(s);
            }else{
                tempList = map.get(sortedStr);
                tempList.add(s);
            }
            
            map.put(sortedStr, tempList);
        }
        return new ArrayList(map.values());
    }
}