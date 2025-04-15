class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26) return false;
        int[] arr = new int[26];
        int count = 26;
        for(int i = 0; i < sentence.length(); i++){
            if(arr[(sentence.charAt(i) - 'a')] == 0){
                count--;
                arr[sentence.charAt(i) - 'a']++;
            } 
            if(count == 0) return true;
        }
        return count == 0;
    }
}