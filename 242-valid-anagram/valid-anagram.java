class Solution {
    public boolean isAnagram(String s, String t) {
    int[] index=new int[26];
    if(s.length()!=t.length())
    {
        return false;
    }
    for(int i=0;i<s.length();i++)
    {
     index[s.charAt(i) - 'a']++;
     index[t.charAt(i) -'a']--;


    }
    for(int count:index)
    {
    if(count!=0)
    {
        return false;
    }
    }
    return true;
    }
}
