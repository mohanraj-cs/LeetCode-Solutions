class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        // Find the middle node
        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. reverse the 2nd half
        ListNode head2 = reverse(slow);

        // step 3. merge the two halves
        merge(head, head2);
    }

    private ListNode reverse(ListNode node) {
        ListNode prevHead = null;
        ListNode head = node;
        while (head != null) {
            ListNode recordNext = head.next; //save next
            head.next = prevHead; // reverse
            prevHead = head; // advance prev
            head = recordNext; // advance currHead
        }
        // Now head will be null at the End of node
        return prevHead; // new Head
    }

    private void merge(ListNode head1, ListNode head2) {
        while (head2 != null) {
            ListNode next = head1.next;
            head1.next = head2;
            head1 = head2;
            head2 = next;
        }
    }
}
