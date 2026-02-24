class Solution {
    public int compress(char[] chars) {
        int writeIndex = 0;

        for(int i = 0; i < chars.length;){
            char curr = chars[i];
            int count = 0;

            while(i < chars.length && curr == chars[i]){
                count++;
                i++;
            }
            chars[writeIndex++] = curr;

            if(count > 1){
                for(char c: String.valueOf(count).toCharArray()){
                    chars[writeIndex++] = c;
                }
            }
        }

        return writeIndex;
    }
}