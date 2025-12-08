class Solution {
    public int countTriples(int n) {
        int count = 0;
        
        for (int m = 2; m * m <= n; m++) {
            for (int k = 1; k < m; k++) {
                if (((m - k) & 1) == 0) continue;  
                if (gcd(m, k) != 1) continue;      

                int a0 = m * m - k * k;
                int b0 = 2 * m * k;
                int c0 = m * m + k * k;

                if (c0 > n) break; 

                int a = a0, b = b0, c = c0;
                while (c <= n) {
                    if (a != b) {
                        count += 2;
                    } else {
                        count += 1;
                    }

                    a += a0;
                    b += b0;
                    c += c0;
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
