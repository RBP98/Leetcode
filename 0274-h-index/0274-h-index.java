class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        while(i < citations.length && i < citations[citations.length - 1 - i]){
            i++;
        }
        return i;
    }
}