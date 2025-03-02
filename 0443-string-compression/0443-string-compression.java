class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int index = 0;
        while(i < chars.length){
            int count = 0;
            char currentChar = chars[i];

            while(i < chars.length && chars[i] == currentChar){
                count++;
                i++;
            }

            chars[index] = currentChar;
            index++;

            if(count > 1){
                String s = Integer.toString(count);
                for(int c = 0; c < s.length(); c++){
                    chars[index] = s.charAt(c);
                    index++;
                }
                
                // while(count != 0){
                //     chars[index] = (char)(count%10 + '0');
                //     index++;
                //     count = count/10;
                // }
            }
        }
        return index;
    }
}