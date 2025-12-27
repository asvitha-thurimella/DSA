import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // available rooms (min room number)
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) available.offer(i);

        // busy rooms: [endTime, room]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        int[] count = new int[n];

        for (int[] m : meetings) {
            long start = m[0], end = m[1];
            long duration = end - start;

            // free rooms that have finished
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }

            if (!available.isEmpty()) {
                int room = available.poll();
                busy.offer(new long[]{end, room});
                count[room]++;
            } else {
                long[] earliest = busy.poll();
                long newEnd = earliest[0] + duration;
                int room = (int) earliest[1];
                busy.offer(new long[]{newEnd, room});
                count[room]++;
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) ans = i;
        }
        return ans;
    }
}
