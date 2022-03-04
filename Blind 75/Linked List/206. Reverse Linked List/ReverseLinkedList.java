/* iterative solution */
public ListNode reverseList(ListNode head) {
    ListNode prevHead = null;
    while (head != null) {
        ListNode recordNext = head.next; //save next
        head.next = prevHead; // reverse
        prevHead = head; // advance prev
        head = recordNext; // advance currHead
    }
    // Now head and prev will be null at the End of node
    return prevHead; // new Head
}

/* My recursive solution */
public ListNode reverseList(ListNode head) {
    return reverseListInt(head, null);
}

private ListNode reverseList(ListNode head, ListNode prevHead) {
    if (head == null)
        return prevHead;
    ListNode next = head.next;
    head.next = prevHead;
    return reverseListInt(next, head);
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
