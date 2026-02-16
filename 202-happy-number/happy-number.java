class Solution {
    public boolean isHappy(int n) {
    Set<Integer> set=new HashSet<>();
    while(n!=1 && !set.contains(n))
    {
      set.add(n);
       n=squareSum(n);
    }
       return n==1; 
    
    
    }

    
    public static int squareSum(int m)
    {
      int sum=0;
      while(m>0)
      {
      int digit=m%10;
      sum=sum+digit*digit;
      m=m/10;

    }
     return sum;
    }
}