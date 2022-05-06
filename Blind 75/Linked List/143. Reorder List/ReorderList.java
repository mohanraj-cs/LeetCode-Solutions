//Method 1
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        // Find the middle node
        // step 1. cut the list to two halves
        // Go fast one step ahead, so gap will be sufficient for odd size
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // step 2. reverse the 2nd half
        ListNode head2 = reverse(slow.next);
        slow.next = null;

        // step 3. merge the two halves
        merge(head, head2);
    }

    private ListNode reverse(ListNode head) {
        ListNode preHead = null;
        ListNode handler = head;
        while (handler != null) {
            ListNode recordNext = handler.next; //save next
            handler.next = preHead; // reverse
            preHead = handler; // advance prev
            handler = recordNext; // advance currHead
        }
        // Now head will be null at the End of node
        return preHead; // new Head
    }

    private void merge(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            ListNode tmp1 = head1.next;
            ListNode tmp2 = head2.next;
            head2.next = head1.next;
            head1.next = head2;
            head1 = tmp1;
            head2 = tmp2;
        }
    }
}


//Method 2
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
