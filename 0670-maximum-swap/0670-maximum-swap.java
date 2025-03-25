class Solution {
    public int maximumSwap(int num) {
        char arr[] = Integer.toString(num).toCharArray();
        int n = arr.length;
        int maxFromRight[] = new int[n];
        maxFromRight[n - 1] = n - 1;
        for(int i = n - 2; i >= 0; i--){
            if(arr[i] > arr[maxFromRight[i + 1]]){
                maxFromRight[i] = i;
            }else{
                maxFromRight[i] = maxFromRight[i + 1];
            }
        }

        for(int i = 0; i < n; i++){
            if(arr[maxFromRight[i]] > arr[i]){
                char temp = arr[i];
                arr[i] = arr[maxFromRight[i]];
                arr[maxFromRight[i]] = temp;
                return Integer.parseInt(new String(arr));
            }
        }

        return num;
    }
}