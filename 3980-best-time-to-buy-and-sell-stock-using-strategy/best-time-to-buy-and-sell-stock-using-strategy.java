class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long baseProfit = 0;
        for (int i = 0; i < n; i++) {
            baseProfit += (long) strategy[i] * prices[i];
        }

        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (long) strategy[i] * prices[i];
        }

        long bestDelta = 0;
        int half = k / 2;

       
        for (int l = 0; l + k <= n; l++) {
            int mid = l + half;
            int r = l + k;

            long original = pref[r] - pref[l];

            long modified = 0;

            
            for (int i = mid; i < r; i++) {
                modified += prices[i];
            }

            long delta = modified - original;
            bestDelta = Math.max(bestDelta, delta);
        }

        return baseProfit + bestDelta;
    }
}
