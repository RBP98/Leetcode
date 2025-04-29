class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int index = 0;

        while(i < chars.length){
            char curr = chars[i];
            int count = 0;
            while(i < chars.length && curr == chars[i]){
                count++;
                i++;
            }
            chars[index] = curr;
            index++;

            if(count > 1){
                String s = String.valueOf(count);
                for(int j = 0; j < s.length(); j++){
                    chars[index] = s.charAt(j);
                    index++;
                }
            }
        }
        return index;
    }
}