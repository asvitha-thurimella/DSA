import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int n = arr.length;
        if (n == 0) return arr;

        // Make a copy of the original array
        int[] sorted = arr.clone();

        // Sort the copy
        Arrays.sort(sorted);

        // Map each unique value to its rank
        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}