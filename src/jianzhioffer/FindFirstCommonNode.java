package jianzhioffer;

/**
 * Created by ying on 2019/3/8.
 */
public class FindFirstCommonNode {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next=n2;
        n2.next=n3;
        n3.next=n6;
        n6.next=n7;

        n4.next = n5;
        n5.next = n6;
        ListNode l =  FindFirstCommonNode(n1,n4);
        System.out.println(l.val);
    }


    public static  ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 ==null)
            return null;
        ListNode p = pHead1;
        while(p.next != null){
            p=p.next;
        }
        p.next = pHead1;
        ListNode slow = pHead2,fast = pHead2;
        while(slow.next != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        fast = pHead2;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }
}

 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
