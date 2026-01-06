class Solution {
    public double findMaxAverage(int[] nums, int k) {
    int sum=0;
    int n=nums.length;
    if(n<k) 
    {
        return -1;
    }
    for( int i=0;i<k;i++)
    {
     sum=sum+nums[i];
    }
    int maxsum=sum;
    int startindex=0;
    int lastindex=k;
    while(lastindex < n)
    {
     sum=sum-nums[startindex];
     startindex++;
     sum=sum+nums[lastindex];
     lastindex++;
     maxsum=Math.max(maxsum,sum);
    }
      return (double) maxsum/k;
        }
}