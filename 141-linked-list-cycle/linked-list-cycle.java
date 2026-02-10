public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode faster = head;

        while (faster != null && faster.next != null) {
            slow = slow.next;
            faster = faster.next.next;

            if (slow == faster) {
                return true;
            }
        }

        return false;
    }
}
