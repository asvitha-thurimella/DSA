import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
       
        if (s.length() != t.length()) {
            return false;
        }

    
        HashMap<Character, Character> hmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (hmap.containsKey(charS)) {
               
                if (hmap.get(charS) != charT) {
                    return false;
                }
            } else {
               
                if (hmap.containsValue(charT)) {
                    return false;
                }
               
                hmap.put(charS, charT);
            }
        }

       
        return true;
    }
}
