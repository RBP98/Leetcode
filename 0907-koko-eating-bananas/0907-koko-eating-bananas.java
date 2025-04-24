class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0;
        for(int i : piles){
            high = Math.max(i, high);
        }

        int low = 1;
        int answer = high;

        while(low <= high){
            int mid =  low + (high - low) / 2;
            long hours = 0;
            for(int i = 0; i < piles.length; i++){
                hours = hours + ((piles[i] + mid - 1) / mid);
            }
            if(hours <= h){
                answer = mid;
                high = mid - 1;
            } 
            else{
                low = mid + 1;
            }  
        }

        return answer;
    }
}