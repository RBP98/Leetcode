class Solution {
    public String customSortString(String order, String s) {
        int[] freqMap = new int[26];

        for(char c: s.toCharArray()){
            freqMap[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char current = order.charAt(i); 
            if(freqMap[current - 'a'] != 0){
                int currentCount = freqMap[current - 'a'];
                for(int j = 0; j < currentCount; j++){
                    sb.append(current);
                    freqMap[current - 'a']--;
                }
            }
        }

        for(int i = 0; i < 26; i++){
            while(freqMap[i] != 0){
                sb.append((char)(i + 'a'));
                freqMap[i]--;
            }
        }

        return sb.toString();
    }
}