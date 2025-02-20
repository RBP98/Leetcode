class Solution {
    public int titleToNumber(String columnTitle) {
        int value = 0;
        for(int i = 0; i < columnTitle.length(); i++){
            char curr = columnTitle.charAt(i);
            value = value * 26 + (int)(curr - 'A') + 1;
        }

        return value;
    }
}