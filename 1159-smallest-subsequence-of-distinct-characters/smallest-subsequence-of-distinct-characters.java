class Solution {
    public String smallestSubsequence(String s) {
    Stack<Character> stack=new Stack<>();
    int[] lastindex=new int[26];
    for(int i=0;i<s.length();i++)
    {
        lastindex[s.charAt(i)-'a']=i;
    }
    boolean[] visited=new boolean[26];
    for(int i=0;i<s.length();i++)
    {
        if(visited[s.charAt(i)-'a'])
        {
          continue;
        }
    while(!stack.isEmpty() && s.charAt(i)< stack.peek() && lastindex[stack.peek()-'a'] >i)
        {
           visited[stack.pop()-'a']=false;
        }
        
        
       
      stack.push(s.charAt(i));
      visited[s.charAt(i)- 'a'] = true;

    }
    StringBuilder sb=new StringBuilder();
    for (char content : stack)
    {
        sb.append(content);
    }
    return sb.toString();
}
}