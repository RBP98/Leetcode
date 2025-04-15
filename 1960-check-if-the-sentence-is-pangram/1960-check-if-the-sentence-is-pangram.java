class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26) return false;
        // int[] arr = new int[26];
        // int count = 26;
        for(char c = 'a'; c <= 'z'; c++){
            if(sentence.indexOf(c) < 0){
                return false;
            }
            
            // if(arr[(sentence.charAt(i) - 'a')] == 0){
            //     count--;
            //     arr[sentence.charAt(i) - 'a']++;
            // } 
            // if(count == 0) return true;
        }
        return true;
    }
}