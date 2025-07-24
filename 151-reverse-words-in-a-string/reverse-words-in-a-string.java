class Solution {
    public String reverseWords(String s) {
    String[] array=s.trim().split("\\s+");
    StringBuilder sc=new StringBuilder();
    for(int i=array.length-1;i>=0;i--)
    {
      sc.append(array[i]);
      if(i!=0)
      {
      sc.append(" ");
    }

    }
    
       return sc.toString(); 
    }
}