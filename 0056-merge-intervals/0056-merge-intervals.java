class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] currentInterval = intervals[0];
        List<int[]> output = new ArrayList<>();
        output.add(currentInterval);
        for(int i = 1; i < intervals.length; i++){
            int[] interval = intervals[i];
            if(currentInterval[1] >= interval[0]){
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            }else{
                currentInterval = interval;
                output.add(currentInterval);
            }
            
        }
        return output.toArray(new int[output.size()][]);
    }
}