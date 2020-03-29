package pickone.medium;

public class ReverseBetween92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        head.next = node2;
        node2.next=node3;
        node3.next= node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode root = reverseBetween(head, 1,5);
        while(root!=null){
            System.out.print(root.val + "\t");
            root = root.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //需要考虑head改变的时候
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode node = root;
        for (int i = 0; i <m-1 ; i++) {
            node = node.next;
        }
        ListNode node2 = node.next;
        ListNode  q = node.next;
        ListNode next = q.next;
        for (int i = m; i <n ; i++) {
            ListNode p = next.next;
            next.next = q;
            q = next;
            next = p;
        }
        node2.next = next;
        node.next = q;
        return root.next;
    }
}
