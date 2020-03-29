package pickone.medium;

/**
 * Created by ying on 2019/8/9.
 */
public class RemoveNthFromEnd19 {
    public static void main(String[] args) {

    }
     /*双指针，一个先走n步，另外一个在走。注意：删除头结点的情况*/
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head, p = head;
        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }
        if (pre == null) {
            head = p.next;
            return head;
        }

        while (pre.next != null) {
            pre = pre.next;
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }
}

