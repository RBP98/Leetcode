class Solution {
    public int countPrimes(int n) {
        // if (n <= 2) {
        //     return 0;
        // }
        boolean[] sieve = new boolean[n];
        for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(!sieve[i]){
                for(int j = i * i; j < n; j = j + i){
                    sieve[j] = true;
                }
            }
        }
        int count = 0;
        for(int j = 2; j < n; j++){
            if(sieve[j] == false) count++;
        }

        return count;

    }
}