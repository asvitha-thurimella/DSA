class Solution {
    public boolean checkPerfectNumber(int num) {
    int original=num;
    int sum=0;
    if (num <= 1)
      return false;
    for(int i=1;i<num;i++)
    {
        if(num%i==0)
        {
         sum+=i;
        }
    }
    return original==sum;
    }
}