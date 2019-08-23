package pickone.hard;


import java.util.PriorityQueue;

public class MergeKLists23 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);

        ListNode n = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);

        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(6);
        head.next = node2;
        node2.next = node3;

        n.next = node4;
        node4.next = node5;

        node6.next = node7;
        ListNode[] list = new ListNode[3];
        list[0] = head;
        list[1] = n;
        list[2] = node6;

        ListNode root = mergeKLists(list);
        while (root != null) {
            System.out.print(root.val + "\t");

        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode p = result;
        PriorityQueue<Temp> queue = new PriorityQueue();
        int length = lists.length;
        ListNode[] index = new ListNode[length];
        for (int i = 0; i < length; i++) {
            if (lists[i] != null) {
                Temp t = new Temp(i, lists[i].val);
                queue.add(t);
                index[i] = lists[i];
            }
        }
        while (!queue.isEmpty()) {
            Temp t = queue.poll();
            p.next = new ListNode(t.val);
            p = p.next;
            ListNode next = index[t.index].next;
            if (next != null) {
                Temp t2 = new Temp(t.index, next.val);
                index[t.index] = next;
                queue.add(t2);
            }

        }
        return result.next;
    }

}

class Temp implements Comparable<Temp> {
    int val;
    int index;

    public Temp(int index, int val) {
        this.index = index;
        this.val = val;
    }


    @Override
    public int compareTo(Temp o) {
        if (o.val > this.val)
            return -1;
        else if (o.val < this.val)
            return 1;
        return 0;
    }

    public void print() {
        System.out.println("index:" + this.index + "val:" + this.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
