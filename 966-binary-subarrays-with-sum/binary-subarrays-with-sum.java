class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
      return sum(nums,goal)-sum(nums,goal-1);
    }
    public int sum(int[] nums,int goal)
    {
    if(goal <0)
    {
    return 0;
    }
    int count=0;
    int sum=0;
    int left=0;
    for(int right=0;right<nums.length;right++)
    {
      sum=sum+nums[right];
      while(sum > goal)
      {
       sum=sum-nums[left];
       left++;
      }
      count+=right-left+1;
     
    }
       return count;
      }  
     
    
}
