public void reorderList(ListNode head) {
	if (head == null) {
		return;
	}

	// Find the middle node
	ListNode slow = head, fast = head.next;
	while (fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;
	}

	// Reverse the second half
	ListNode head2 = reverse(slow.next);
	slow.next = null;

	// Link the two halves together
	while (head != null && head2 != null) {
		ListNode tmp1 = head.next;
		ListNode tmp2 = head2.next;
		head2.next = head.next;
		head.next = head2;
		head = tmp1;
		head2 = tmp2;
	}
}

private ListNode reverse(ListNode node) {
	ListNode prevHead = null;
	ListNode head = node;
	while (head != null) {
		ListNode tmp = head.next;
		head.next = prevHead;
		prevHead = head;
		head = tmp;
	}
	return prevHead;
}