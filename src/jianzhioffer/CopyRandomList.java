package jianzhioffer;

/**
 * Created by ying on 2019/3/5.
 */
public class CopyRandomList {
    public static void main(String[] args) {
        RandomListNode t1 = new  RandomListNode(1);
        RandomListNode t2 = new RandomListNode(2);
        RandomListNode t3 = new RandomListNode(3);
        RandomListNode t4= new RandomListNode(4);
        RandomListNode t5 = new RandomListNode(5);

        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;

       t1.random = t3;
       t2.random = t5;
       t3.random = null;
       t4.random = t2;
       t5.random = null;

        RandomListNode result = Clone(t1);
        RandomListNode temp = result;
        while(temp!=null){
            System.out.println(temp.label+"   "+temp.next+"  "+temp.random);
            temp = temp.next;
        }
    }

    public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        RandomListNode orij = pHead;
        RandomListNode copyHead = new RandomListNode(orij.label);
        RandomListNode copy = copyHead;
        int num = 1;
        while(orij.next!=null){
            RandomListNode temp = new RandomListNode(orij.next.label);
            copy.next = temp;
            copy = copy.next;
            orij = orij.next;
            num++;
        }
        RandomListNode oend = orij;
        RandomListNode cend = copy;
        oend.next = pHead;
        cend.next = copyHead;

        orij = pHead;
        copy = copyHead;
        for(int j = 0;j<num;j++){
            if(orij.random == null){
                copy.random = null;
                orij = orij.next;
                copy = copy.next;
                continue;
            }
            int count = 0;
            RandomListNode temp = orij;
            while(orij.random != temp){
                temp = temp.next;
                count++;
            }
            RandomListNode random1 = copy;
            for(int i=0;i< count;i++){
                random1 = random1.next;
            }
            copy.random = random1;
            orij = orij.next;
            copy = copy.next;
        }
        oend.next = null;
        cend.next = null;
        return copyHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
