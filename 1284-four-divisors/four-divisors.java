class Solution {
    public int sumFourDivisors(int[] nums) {
   
    int totalsum=0;
    for(int i=0;i<nums.length;i++)
    {
        int j=1;
    int count=0;
    int sum=0;
    while(j<=nums[i]) 
    {
       if(nums[i] % j==0)
       {
        count++;
        sum=sum+j;
       }
       if(count > 4)
       {
        break;
       }
        j++;
    }
       if(count==4)
       {
        totalsum=totalsum+sum;
       }
      
    }  
    
    return totalsum;
}
}