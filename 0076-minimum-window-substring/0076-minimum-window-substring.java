class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mapT = new HashMap<>();
        for(char c: t.toCharArray()){
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int required = mapT.size();
        // A:1 B:1 C:1
        List<Pair<Integer, Character>> filteredS = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(mapT.containsKey(c)){
                filteredS.add(new Pair(i, c));
            }
        }
        // 0:A 3:B 5:C 9:B 10:A 11:C 

        int left = 0;
        int right = 0;
        int formed = 0;

        Map<Character, Integer> window = new HashMap<>();
        int[] ans = {-1, 0, 0}; 
        while(right < filteredS.size()){
            char c = filteredS.get(right).getValue();
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(window.get(c).intValue() == mapT.get(c).intValue()){ 
                formed++;
            }

            while(left <= right && formed == required){
                char leftC = filteredS.get(left).getValue();

                int end = filteredS.get(right).getKey();
                int start = filteredS.get(left).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                window.put(leftC, window.get(leftC) - 1);
                if (window.get(leftC).intValue() < mapT.get(leftC).intValue()) {
                    formed--;
                }
            left++;
            }
        right++;
        }

        return ans[0] == -1 ? "": s.substring(ans[1], ans[2] + 1);
    }
}