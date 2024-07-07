class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            if(map.containsKey(order.charAt(i))){
                int count = map.get(order.charAt(i));
                for(int j = 0; j < count; j++){
                    sb.append(order.charAt(i));
                    map.put(order.charAt(i), map.get(order.charAt(i)) - 1);
                }    
            }
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() != 0){
                for(int i = 0; i < entry.getValue(); i++){
                    sb.append(entry.getKey());
                }
            }
        }
    return sb.toString();
    }
}