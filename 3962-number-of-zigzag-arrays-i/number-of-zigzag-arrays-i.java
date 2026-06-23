class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] inc = new long[m];
        long[] dec = new long[m];

        // length = 2 initialization
        for (int i = 0; i < m; i++) {
            inc[i] = i;             // values smaller than current
            dec[i] = m - 1 - i;     // values larger than current
        }

        // build length 3 to n
        for (int len = 3; len <= n; len++) {
            long[] newInc = new long[m];
            long[] newDec = new long[m];

            long[] prefixDec = new long[m];
            long[] prefixInc = new long[m];

            prefixDec[0] = dec[0];
            prefixInc[0] = inc[0];

            for (int i = 1; i < m; i++) {
                prefixDec[i] = (prefixDec[i - 1] + dec[i]) % MOD;
                prefixInc[i] = (prefixInc[i - 1] + inc[i]) % MOD;
            }

            for (int x = 0; x < m; x++) {
                // previous was decreasing, now must increase
                if (x > 0)
                    newInc[x] = prefixDec[x - 1];

                // previous was increasing, now must decrease
                newDec[x] = (prefixInc[m - 1] - prefixInc[x] + MOD) % MOD;
            }

            inc = newInc;
            dec = newDec;
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = (ans + inc[i] + dec[i]) % MOD;
        }

        return (int) ans;
    }
}