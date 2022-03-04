public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast)
            return true;
    }
    return false;
}


// Other variables names
// walker and runner,good metaphor.
// Walker goes 1 step at a time,and runner goes 2 steps at a time.
// If we think walker is still,then runner goes 1 step at a time.
// So,the problem is just like a Chasing problem.
// There is a time when runner catches walker
public boolean hasCycle(ListNode head) {
    if (head == null)
        return false;
    ListNode walker = head;
    ListNode runner = head;
    while (runner.next != null && runner.next.next != null) {
        walker = walker.next;
        runner = runner.next.next;
        if (walker == runner)
            return true;
    }
    return false;
}
