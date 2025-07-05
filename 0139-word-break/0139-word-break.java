class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, Boolean> dp = new HashMap<>();
        return helper(s, wordSet, dp);
    }

    private boolean helper(String s, Set<String> wordSet, Map<String, Boolean> dp){
        if(s.length() == 0){
            return true;
        }
        if(dp.containsKey(s)) return dp.get(s);

        for(int i = 1; i <= s.length(); i++){
            String sub = s.substring(0, i);

            if(wordSet.contains(sub)){
                String suff = s.substring(i);

                if(helper(suff, wordSet, dp)){
                    dp.put(s, true);
                    return true;
                } 
            }
        }
        dp.put(s, false);
        return false;
    }
}