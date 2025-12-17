class Solution {
    public long maximumProfit(int[] prices, int k) {
        long NEG = Long.MIN_VALUE / 2;

        long[][] dp = new long[k + 1][3];

        for (int i = 0; i <= k; i++) {
            dp[i][0] = NEG;
            dp[i][1] = NEG;
            dp[i][2] = NEG;
        }

        dp[0][0] = 0; 

        for (int price : prices) {
            for (int t = k; t >= 0; t--) {

                
                if (t < k) {
                    // sell long
                    dp[t + 1][0] = Math.max(dp[t + 1][0], dp[t][1] + price);

                    // buy back short
                    dp[t + 1][0] = Math.max(dp[t + 1][0], dp[t][2] - price);
                }

                // Open positions
                // buy (long)
                dp[t][1] = Math.max(dp[t][1], dp[t][0] - price);

                // short sell
                dp[t][2] = Math.max(dp[t][2], dp[t][0] + price);
            }
        }

        long ans = 0;
        for (int t = 0; t <= k; t++) {
            ans = Math.max(ans, dp[t][0]); // must end with no open position
        }
        return ans;
    }
}
