package pickone.medium;

/**
 * Created by ying on 2019/4/30.
 */
public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode pre = null;
        int signal = 0;
        while (l1 != null || l2 != null) {
            int temp;
            if (l1 == null) {
                temp = l2.val + signal;
                l2 = l2.next;
            } else if (l2 == null) {
                temp = l1.val + signal;
                l1 = l1.next;
            } else {
                temp = l1.val + l2.val + signal;
                l1 = l1.next;
                l2 = l2.next;
            }
            ListNode n = new ListNode(temp % 10);
            if (result == null) {
                result = n;
                pre = result;
            } else {
                pre.next = n;
                pre = pre.next;
            }
            signal = temp / 10;

        }
        if (signal != 0) {
            ListNode node = new ListNode(signal);
            pre.next = node;
        }
        return result;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
