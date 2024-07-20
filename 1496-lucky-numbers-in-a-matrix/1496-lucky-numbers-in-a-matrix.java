class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int maxOfRowMins = Integer.MIN_VALUE;
        int minOfColMaxs = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < matrix[0].length; j++){
                min = Math.min(min, matrix[i][j]);
            }
            maxOfRowMins = Math.max(min, maxOfRowMins);
        }
        for(int i = 0; i < matrix[0].length; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < matrix.length; j++){
                max = Math.max(max, matrix[j][i]);
            }
            minOfColMaxs = Math.min(max, minOfColMaxs);
        }
        List<Integer> ans = new ArrayList<Integer>();
        
        System.out.println(maxOfRowMins);
        System.out.println(minOfColMaxs);
        
        if(maxOfRowMins == minOfColMaxs){
            ans.add(maxOfRowMins);
            return ans;
        }
    return ans;
    }
}