class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char max = s.charAt(0);
        for(char c: s.toCharArray()){
           map.put(c, map.getOrDefault(c,0) + 1);
           if(map.get(c) > map.get(max)){
            max = c;
           }
        }
        if(map.get(max) > (s.length() + 1) / 2){
            return "";
        }
        int index = 0;
        char[] result = new char[s.length()];

        while(index < s.length() && map.get(max) > 0){
            result[index] = max;
            map.put(max, map.get(max) - 1);
            index = index + 2;
        }

        for(char c : map.keySet()){
            while(map.get(c) > 0){
                if(index >= s.length()) 
                    index = 1;

                result[index] = c;
                index = index + 2;
                map.put(c, map.get(c) - 1);
            }


        }
    return String.valueOf(result);
    }   
}