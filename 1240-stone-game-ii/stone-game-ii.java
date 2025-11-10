class Solution {
   
    private int[] prefixSum;
    
    private Integer[][] dp;
    // Total number of piles
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
      
       
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + piles[i];
        }
      
        // Initialize memoization table
        dp = new Integer[n][n + 1];
      
        // Start the game from index 0 with M = 1
        return dfs(0, 1);
    }

    /**
     
     * @param index 
     * @param M 
     * @return 
     */
    private int dfs(int index, int M) {
        // Base case: if we can take all remaining piles, take them all
        if (2 * M >= n - index) {
            return prefixSum[n] - prefixSum[index];
        }
      
        
        if (dp[index][M] != null) {
            return dp[index][M];
        }
      
        int maxStones = 0;
      
        // Try taking X piles where X is from 1 to 2*M
        for (int X = 1; X <= 2 * M; X++) {
            
            int currentPlayerStones = prefixSum[n] - prefixSum[index] - 
                                      dfs(index + X, Math.max(M, X));
            maxStones = Math.max(maxStones, currentPlayerStones);
        }
      
       
        dp[index][M] = maxStones;
        return maxStones;
    }
}