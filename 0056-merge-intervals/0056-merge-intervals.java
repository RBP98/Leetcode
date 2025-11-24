class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int[] prev = intervals[0];
      
        for(int[] curr: intervals){
            if(prev[1] >= curr[0]){
                prev[1] = Math.max(prev[1], curr[1]);
            }else{
                list.add(prev);
                prev = curr;
            }
        }
        list.add(prev);

        int[][] res= new int[list.size()][2];
        int count = 0;
        for(int[] i: list){
            res[count++] = i;
        }
        return res;
    }
}