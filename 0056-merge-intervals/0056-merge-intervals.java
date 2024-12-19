class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> output = new ArrayList<>();
        int[] current = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] next = intervals[i];
            if(next[0] <= current[1]){
                current[1] = Math.max(next[1], current[1]);
            }
            else{
                output.add(current);
                current = next;
            }
        }
        output.add(current);
        return output.toArray(new int[output.size()][]);
    }
}