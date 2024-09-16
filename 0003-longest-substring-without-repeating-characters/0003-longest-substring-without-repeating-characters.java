class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int max = 0;
        // Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while(right < n){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            if(map.size() == right - left + 1){
                max = Math.max(max, right - left + 1);
                right++;
            }else if(map.size() < right - left + 1){
                while(map.size() < right - left + 1){
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    if(map.get(s.charAt(left)) == 0){
                        map.remove(s.charAt(left));
                    }
                    left++;
                }
                right++;
            }
            





            // if(!set.contains(s.charAt(right))){
            //     set.add(s.charAt(right));
            //     max = Math.max(max, right - left + 1);
            // }else{
            //     while(s.charAt(left) != s.charAt(right)){
            //         set.remove(s.charAt(left));
            //         left++;
            //     }
                
            //     max = Math.max(max, right - left + 1);
            //     right++;
            //     left++;
            // }

        }
        return max;
    }
}