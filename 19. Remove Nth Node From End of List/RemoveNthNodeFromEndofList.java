//Optimised Solution || O(N) || two pointer technique
// fast pointer will maintain the distance from the end of the list for the slow pointer

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n){
      ListNode start = new ListNode(0, head);
      ListNode slow = start, fast = start;
      for(int i=1; i<=n+1; i++) {
          fast = fast.next;
      }
      while(fast != null) {
          slow = slow.next;
          fast = fast.next;
      }
      slow.next = slow.next.next;
      return start.next;
  }
}