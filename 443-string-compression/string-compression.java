class Solution {
    public int compress(char[] chars) {
 int index=0;

int start=0;
while(index < chars.length)
{
  char currentarr=chars[index];
  int count=0;
  
  while(index < chars.length && chars[index]== currentarr)
  {
   count++;
   index++;
  }
  chars[start++]=currentarr;
   if (count > 1) {
    for (char c : String.valueOf(count).toCharArray()) {
     chars[start++] = c;
}
   }
}
 return start;
    }
}