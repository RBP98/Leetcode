class Solution {
    public String customSortString(String order, String s) {
        int[] freqArr = new int[26];

        for(char c : s.toCharArray()){
            freqArr[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            int count = freqArr[order.charAt(i) - 'a'];
            for(int j = 0; j < count; j++){
                sb.append(order.charAt(i));
                      freqArr[order.charAt(i) - 'a']--;
      
            }
        }

        for(int i = 0; i < freqArr.length; i++){
            if(freqArr[i] != 0){
                for(int j = 0; j < freqArr[i]; j++){
                    sb.append((char)(i + 'a'));
                }
            }
        }

        return sb.toString();
    }
}