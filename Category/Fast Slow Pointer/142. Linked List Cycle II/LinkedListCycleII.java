// An easier formula to explain to the interviewer:
// Distance traveled by slow when they meet: L1+L2
// Distance traveled by fast when they meet: L1+L2+x+L2, where x is the remaining length of the cycle (meeting point to start of the cycle).
//
// 2(L1+L2) = L1+L2+x+L2
// 2L1 + 2L2 = L1+2L2+x
// => x = L1
//
// so we need to move L1 steps from the current meeting point to reach the entry point of the cycle.

public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head, entry = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (slow == fast) { // there is a cycle
            while (entry != slow) { // found the entry location
                slow = slow.next;
                entry = entry.next;
            }
            return entry;
        }
    }
    return null; // there has no cycle
}
