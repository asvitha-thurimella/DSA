class Solution {
    public long sumAndMultiply(int n) {
     String s = Integer.toString(n);
        StringBuilder filtered = new StringBuilder();
        long digitSum = 0;
        
        for (char c : s.toCharArray()) {
            if (c != '0') {
                filtered.append(c);
                digitSum += (c - '0');
            }
        }
        
        if (filtered.length() == 0) {
            return 0;
        }
        
        long x = Long.parseLong(filtered.toString());
        return x * digitSum;   
    }
}