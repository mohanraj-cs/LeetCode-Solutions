// O(NLogK) - Divide and conquer - Merge Sort
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (end < start)
            return null;
        if (start == end)
            return lists[start];
        if (start + 1 == end)
            return mergeTwoLists(lists[start], lists[end]);

        int mid = start + ((end - start) / 2);
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode handler = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                handler.next = l1;
                l1 = l1.next;
            } else {
                handler.next = l2;
                l2 = l2.next;
            }
            handler = handler.next;
        }
        if (l1 != null)
            handler.next = l1;
        else if (l2 != null)
            handler.next = l2;
        return head.next;
    }
}

//To Do Priority Queu
