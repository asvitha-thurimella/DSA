/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
    
        // Handle edge case: if list has only one node, return as is
        if (head == null || head.next == null) {
            return head;
        }
      
        // Traverse the list with two pointers: previous and current
        ListNode previous = head;
        ListNode current = head.next;
      
        while (current != null) {
           
            int gcdValue = gcd(previous.val, current.val);
          
           
            ListNode gcdNode = new ListNode(gcdValue, current);
            previous.next = gcdNode;
          
           
            previous = current;
          
            current = current.next;
        }
      
        return head;
    }
  
    private int gcd(int a, int b) {
        
        if (b == 0) {
            return a;
        }
      
        return gcd(b, a % b);
    }
}