class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        int[] current = intervals[0];
        merged.add(current);

        for(int[] interval: intervals){
            if(current[1] >= interval[0]){
                current[1] = Math.max(current[1], interval[1]);
            }else{
                current = interval;
                merged.add(interval);
            }
        }

        return merged.toArray(new int[merged.size()][]);


    }
}