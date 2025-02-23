class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int m = 0;
        int n = 0;
        
        List<int[]> output = new ArrayList<>();
        while(m < firstList.length && n < secondList.length){
            int low = Math.max(firstList[m][0], secondList[n][0]);
            int high = Math.min(firstList[m][1], secondList[n][1]);

            if(low <= high){
                output.add(new int[]{low, high});
            }

            if(firstList[m][1] < secondList[n][1]){
                m++;
            }else{
                n++;
            }
        }
    return output.toArray(new int[output.size()][]);
    }
}