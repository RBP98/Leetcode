class Solution {
    private boolean isVowel(char c){
        String vowels = "AEIOUaeiou";
        return vowels.indexOf(c) != -1;
    }
    public String reverseVowels(String s) {
        char[] c = s.toCharArray(); 
        int left = 0; 
        int right  = c.length - 1;
        while(left < right){
            if(isVowel(c[left]) && isVowel(c[right])){
                char temp = c[left];
                c[left] = c[right]; 
                c[right] = temp;
                left++;
                right--;
            }else if(isVowel(c[left])){
                right--;

            }
            else if(isVowel(c[right])){
                left++;
            }else{
                left++;
                right--;
            }
        }
        return String.valueOf(c);
    }
}