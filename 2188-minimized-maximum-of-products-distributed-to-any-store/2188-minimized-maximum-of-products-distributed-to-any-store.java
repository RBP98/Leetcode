class Solution {
    private int findMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i: piles){
            if(max < i){
                max = i;
            }
        }
        return max;
    }
    public int minimizedMaximum(int h, int[] piles) {
        int max = findMax(piles);
        int low = 0; 
        int high = max;
        int answer = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high)/2;
            int hours = calculateTotalHours(piles, mid);
            if(hours <= h){
                answer = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return answer;
    }

    private int calculateTotalHours(int[] piles, int bph){
        int totalHours = 0;
        for(int i = 0; i < piles.length; i++){
            totalHours += Math.ceil((double)piles[i]/(double)bph);
        }
        return totalHours;
    }
    
}