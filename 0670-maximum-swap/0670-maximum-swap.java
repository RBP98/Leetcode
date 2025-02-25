class Solution {
    public int maximumSwap(int num) {
        char[] str = Integer.toString(num).toCharArray();
        int n = str.length;
        int[] maxFromRight = new int[n];
        maxFromRight[n - 1] = n - 1;
        for(int i = n - 2; i >= 0; i--){
            maxFromRight[i] = str[i] > str[maxFromRight[i + 1]] ? i : maxFromRight[i + 1];
        }

        for(int i = 0; i < n; i++){
            if(str[maxFromRight[i]] > str[i]){
                char temp = str[i];
                str[i] = str[maxFromRight[i]];
                str[maxFromRight[i]] = temp;
                return Integer.parseInt(new String(str));
            }
        }

    return num;
    }
}