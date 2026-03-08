class Solution {
    public int maxScore(int[] cardPoints, int k) {
    int n=cardPoints.length;
    int leftsum=0;
    int rightsum=0;
    int max=0;
    for(int i = 0; i < k; i++)
            leftsum += cardPoints[i];

    max = leftsum;
    for(int i=1;i<=k;i++)
    {
      leftsum-=cardPoints[k-i];
      rightsum+=cardPoints[n-i];
      max=Math.max(max,leftsum+rightsum);
      }
      return max;
    }
}