class Solution {
    public int compress(char[] chars) {

        int writeIndex = 0;
        for(int i = 0; i < chars.length;){
            char currChar = chars[i];
            int count = 0;
            while(i < chars.length && currChar == chars[i]){
                count++;
                i++;
            }

            chars[writeIndex++] = currChar;
            if(count > 1){
                String s = String.valueOf(count);
                for(int j = 0; j < s.length(); j++){
                    chars[writeIndex++] = s.charAt(j);
                }
            }
            


        }

        return writeIndex;
    }
}