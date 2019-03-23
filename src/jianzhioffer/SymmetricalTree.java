package jianzhioffer;

/**
 * Created by ying on 2019/3/15.
 */
public class SymmetricalTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(7);
        root.right = t2;
        root.left = t1;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        System.out.println(isSymmetrical(root));

    }

   static  boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null)
            return true;
        return leftAndRight(pRoot.left,pRoot.right);
    }
   static  boolean leftAndRight(TreeNode tleft,TreeNode tright){
        if(tleft == null && tright == null)
            return true;
        else if(tright == null || tleft == null)
            return false;
        if(tleft.val == tright.val){
            return (leftAndRight(tleft.left,tright.right)&&leftAndRight(tleft.right,tright.left));
        }else
            return false;
    }
}

