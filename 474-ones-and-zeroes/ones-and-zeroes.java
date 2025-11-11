class Solution {
    
    public int findMaxForm(String[] strs, int m, int n) {
        int stringCount = strs.length;
      
       
        int[][][] dp = new int[stringCount + 1][m + 1][n + 1];
      
        for (int i = 1; i <= stringCount; i++) {
            
            int[] zerosAndOnes = count(strs[i - 1]);
            int zeros = zerosAndOnes[0];
            int ones = zerosAndOnes[1];
          
           
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    
                    dp[i][j][k] = dp[i - 1][j][k];
                  
                    
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(
                            dp[i][j][k], 
                            dp[i - 1][j - zeros][k - ones] + 1
                        );
                    }
                }
            }
        }
      
        return dp[stringCount][m][n];
    }
    private int[] count(String s) {
        int[] zerosAndOnes = new int[2];
      
        for (int i = 0; i < s.length(); i++) {
           
            zerosAndOnes[s.charAt(i) - '0']++;
        }
      
        return zerosAndOnes;
    }
}