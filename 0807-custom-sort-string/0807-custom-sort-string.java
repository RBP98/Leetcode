class Solution {
    public String customSortString(String order, String s) {
        int[] freqArr = new int[26];

        for(int i = 0; i < s.length(); i++){
            freqArr[s.charAt(i) - 'a']++;
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
            while(freqArr[i] != 0){
                sb.append((char)(i + 'a'));
                freqArr[i]--;
            }
        }
        return sb.toString();
    }
}