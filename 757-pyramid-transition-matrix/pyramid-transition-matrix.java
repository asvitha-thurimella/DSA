import java.util.*;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {

        Map<String, List<Character>> map = new HashMap<>();

        for (String s : allowed) {
            String key = s.substring(0, 2);
            char value = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }

        return dfs(bottom, map);
    }

    private boolean dfs(String curr, Map<String, List<Character>> map) {

        if (curr.length() == 1) {
            return true;
        }

        List<String> nextRows = new ArrayList<>();
        buildNextRows(curr, 0, new StringBuilder(), nextRows, map);

        for (String next : nextRows) {
            if (dfs(next, map)) {
                return true;
            }
        }

        return false;
    }

    private void buildNextRows(
            String curr,
            int index,
            StringBuilder sb,
            List<String> result,
            Map<String, List<Character>> map) {

        if (index == curr.length() - 1) {
            result.add(sb.toString());
            return;
        }

        String key = curr.substring(index, index + 2);

        if (!map.containsKey(key)) {
            return;
        }

        for (char ch : map.get(key)) {
            sb.append(ch);
            buildNextRows(curr, index + 1, sb, result, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
