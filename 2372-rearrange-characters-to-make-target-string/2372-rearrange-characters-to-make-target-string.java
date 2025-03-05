class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] first = freqMap(target);
        int[] second = freqMap(s);

        int minMod = Integer.MAX_VALUE;
        
        for(int i = 0; i < 26; i++){
            if(first[i] != 0){
                minMod = Math.min(minMod, second[i] / first[i]);    
            }
            
        }
      return minMod;
    }

     private int[] freqMap(String text){
        int[] res = new int[26];
        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            res[c - 'a']++;
        }    
    return res;
    }
}