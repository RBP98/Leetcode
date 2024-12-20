class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        

        List<int[]> output = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        while(i < n && newInterval[0] > intervals[i][1]){
            output.add(intervals[i]);
            i++;
        }

        while(i < n && newInterval[1] >= intervals[i][0]){
            // System.out.println(" Test");
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);  
            i++;
        }
        output.add(newInterval);

        while(i < n){
            output.add(intervals[i]);
            i++;
        }

        return output.toArray(new int[output.size()][]);
    }
}