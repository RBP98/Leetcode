class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            set.add(c);
        }
        int ans = 0;
        for(char c: set){
            int firstIndex = -1;
            int lastIndex = 0;
            for(int k = 0; k < s.length(); k++){
                if(s.charAt(k) == c){
                    if(firstIndex == -1){
                        firstIndex = k;
                    }
                    lastIndex = k;
                }
            }

            Set<Character> between = new HashSet<>();
            for(int i = firstIndex + 1; i < lastIndex; i++){
                between.add(s.charAt(i));
            }

            ans = ans + between.size();
        }

        return ans;
    }
}