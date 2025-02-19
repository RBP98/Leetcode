class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> output= new ArrayList<>(); 

        int[] currentInterval = intervals[0];
        output.add(currentInterval);

        for(int[] interval: intervals){
            if(currentInterval[1] >= interval[0]){
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            }else{
                currentInterval = interval;
                output.add(currentInterval);
            }
        }
    return output.toArray(new int[0][]);
    }
}