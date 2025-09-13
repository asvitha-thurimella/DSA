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
    public boolean isPalindrome(ListNode head) {
    if(head==null || head.next==null)
     return true;
    ListNode fast=head;
    ListNode slow=head;
    while(fast != null && fast.next!=null)
    {
      slow=slow.next;
      fast=fast.next.next;
    }
    ListNode secondHalf=Reverse(slow);
    ListNode FirstHalf=head;
    while(secondHalf!=null)
    
    {
    if(FirstHalf.val!=secondHalf.val)
    {
        return false;
    }
    FirstHalf=FirstHalf.next;
    secondHalf=secondHalf.next;
    }
     return true;
    }
  
   private ListNode Reverse(ListNode head)
    {
         ListNode prev=null;
    ListNode curr=head;
    while(curr!=null)
    {
     ListNode nextcurr=curr.next;
     curr.next=prev;
     prev=curr;
     curr=nextcurr;
    }
    return prev;
    }
    }

  