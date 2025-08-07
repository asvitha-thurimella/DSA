class Solution {
    public String minWindow(String s, String t) {
    if(s == null || t == null || s.length()<t.length())
    {
        return "";
    }
    Map<Character , Integer> tcount=new HashMap<>();
    Map<Character , Integer> window =new HashMap<>();
    
    for(char ch:t.toCharArray())
    {
     tcount.put(ch,tcount.getOrDefault(ch, 0)+1);
  
    }
    int have=0;
    int need=tcount.size();
    int minLen=Integer.MAX_VALUE;
   
    int minStart=0;
    int left=0;
    for(int i=0;i<s.length();i++)
    {
       char ch =s.charAt(i);
       window.put(ch,window.getOrDefault(ch, 0)+1);

       if(tcount.containsKey(ch) && tcount.get(ch).intValue()== window.get(ch).intValue())
       {
         have++;
       }
     while(have==need)
     {
        if(i-left + 1< minLen)
        {
          minLen=i-left + 1;
          minStart=left;
        }
     char leftchar=s.charAt(left);
     window.put(leftchar,window.get(leftchar)-1);
    if(tcount.containsKey(leftchar) &&  window.get(leftchar) < tcount.get(leftchar))
    {
        have--;
    }
    left++;
          


        }
    }
        return minLen==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minLen);
     }

    }



