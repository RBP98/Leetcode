class Solution {
    public double averageWaitingTime(int[][] customers) {
        long waitTime = 0;
        int idle = 0;
        for(int i = 0; i < customers.length; i++){
            idle = Math.max(idle, customers[i][0]) + customers[i][1];
            waitTime = waitTime + idle - customers[i][0];
        }
        return (double)waitTime/customers.length;
    }
}