class Solution {
    public int getLargestOutlier(int[] nums) {
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i: nums){
            sum = sum + i;
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int result = Integer.MIN_VALUE;
        for(int i: nums){
            int outlier = sum - (2 * i);
            int count = 0; 
            if(outlier == i) count = 1;

            if(map.getOrDefault(outlier, 0) > count){
                result = Math.max(result, outlier);
            }


        }

    return result;
    }
}