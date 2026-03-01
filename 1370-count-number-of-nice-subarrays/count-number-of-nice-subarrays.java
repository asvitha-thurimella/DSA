class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
    return oddsum(nums,k)-oddsum(nums,k-1);
    } 
    public int oddsum(int[] nums,int k)
    {
       int res=0;
       int left=0;
       for(int right=0;right<nums.length;right++)
       {
          if(nums[right]%2!=0)
          {
            k--;
          }
         while(k<0)
         {
         if(nums[left]%2!=0)
            k++;
            left++;
         }
         res+=right-left+1;
     
       }
       return res;
    } 
}