class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode start = head;
        ListNode reverse = reverse(slow);

        while(reverse != null) {
            if(start.val !=  reverse.val) {
                return false;
            }
            reverse = reverse.next;
            start = start.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prevHead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prevHead;
            prevHead = head;
            head = next;
        }
        return prevHead;
    }
}
