/* iterative solution */
public ListNode reverseList(ListNode head) {
    ListNode prevHead = null;
    while (head != null) {
        ListNode recordNext = head.next;
        head.next = prevHead;
        prevHead = head;
        head = recordNext;
    }
    return prevHead;
}

/* recursive solution */
public ListNode reverseList(ListNode head) {
    return reverseListInt(head, null);
}

private ListNode reverseListInt(ListNode head, ListNode newHead) {
    if (head == null)
        return newHead;
    ListNode next = head.next;
    head.next = newHead;
    return reverseListInt(next, head);
}