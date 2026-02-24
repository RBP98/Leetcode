class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];

        for(int[] interval: intervals){
            if(interval[0] <= prev[1]){
                prev[1] = Math.max(prev[1], interval[1]);
            }else{
                res.add(prev);
                prev = interval;
            }
        }
        res.add(prev);

        int[][] ans = new int[res.size()][2];
        
        for(int i = 0; i < res.size(); i++){
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }

        return ans;
    }
}