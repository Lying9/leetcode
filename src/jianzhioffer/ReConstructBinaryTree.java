package jianzhioffer;

/**
 * Created by ying on 2019/1/23.
 * <p>
 * 重建二叉树（根据中序和先序遍历次序）
 */
public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode node = reConstructBinaryTree(pre,in);
        System.out.println("------");
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0)
            return null;
        return reConstructSub(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public static TreeNode reConstructSub(int[] pre, int[] in, int prestart, int preend, int midstart, int midend) {
        int vaule = pre[prestart];
        TreeNode node = new TreeNode(vaule);
        int i;
        for (i = midstart; i <= midend; i++) {
            if (in[i] == vaule)
                break;
        }
//        左孩子
        if(i - midstart >0){
            node.left = reConstructSub(pre,in,prestart+1,prestart+i-midstart,midstart,i-1);
        }else{
            node.left = null;
        }
//        右孩子
        if(midend -i > 0){
            node.right = reConstructSub(pre,in,prestart+i-midstart+1,preend,i+1,midend);
        }else
            node.right = null;
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}