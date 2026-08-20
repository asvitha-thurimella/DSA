class Solution {
    public int reverse(int x) {
    long y=0;
    while(x!=0)
    {
        int digit=x%10;
        y=y*10+digit;
        x=x/10;
    }  
    if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) {
            return 0;
        } 
    return (int) y;
    }
}