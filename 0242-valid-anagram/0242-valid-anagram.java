class Solution {
    public boolean isAnagram(String s, String t) {
        int arr[] = new int[26];
        for(char c: s.toCharArray()){
            arr[c - 'a']++;
        } 

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(arr[c - 'a'] == 0){
                return false;
            }else{
                arr[c - 'a']--;
            }
        }

        for(int i: arr){
            if(i != 0){
                return false;
            }
        }

        return true;
    }
}