// O(n) - Linked List
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
public class Solution {
  public ListNode addTwoNumbers(ListNode x, ListNode y) {
      ListNode result = new ListNode(0);
      ListNode temp = result;
      int sum = 0;
      while(x != null || y != null) {
          sum /= 10;
          if(x != null) {
              sum += x.val;
              x = x.next;
          }
          if( y != null) {
              sum += y.val;
              y = y.next;
          }
          temp.next = new ListNode(sum % 10);
          temp = temp.next;
      }
      if(sum / 10 == 1) {
        temp.next = new ListNode(1);
      }
      return result.next;
  }
}