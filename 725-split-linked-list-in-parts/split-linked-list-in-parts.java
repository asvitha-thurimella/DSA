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
    public ListNode[] splitListToParts(ListNode head, int k) {
    int n=0;
    ListNode curr=head;
    ListNode[] result=new ListNode[k];
    while(curr!=null)
    {
        curr=curr.next;
        n++;
    }
    int size=n/k;
    int extra=n%k;
    curr = head; 
    for(int i=0;i<k;i++)
    {
      result[i]=curr;
      int partsize=size+(extra>0?1:0);
      if(extra>0)
      {
        extra--;
      }
      for(int j=0;j<partsize-1 &&curr != null;j++)
      {
        curr=curr.next;
        
      }
    if(curr != null){
    ListNode nextnode=curr.next;
    curr.next=null;
    curr=nextnode;
    }

    }
    return result;

    }
}