class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.length() != 0 && s.length() >= part.length()) {
            if (s.contains(part)) {
                s = s.replaceFirst(part, "");
            } else {
                break; 
            }
        }
        return s;
    }
}
