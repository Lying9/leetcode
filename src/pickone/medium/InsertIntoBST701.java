package pickone.medium;

/**
 * Created by ying on 2018/9/19.
 */
public class InsertIntoBST701 {
//也可用递归
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(7);
        root.left = a;
        root.right = d;
        a.left =b;
        a.right =c;
        root = insertIntoBST(root,5);
        preprint(root);
    }
    public static  TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        TreeNode t = root,pre= null;
        Boolean isLeft = false;
        while(t!=null){
            pre = t;
            if(t.val > val) {
                t = t.left;
                isLeft = true;
            }
            else {
                t = t.right;
                isLeft = false;
            }
        }
        t = new TreeNode(val);
        if(isLeft)
            pre.left =t;
        else
            pre.right = t;
        return root;
    }
    public static void preprint(TreeNode root){
        if(root == null)
            return;
        System.out.println(root.val);
        preprint(root.left);
        preprint(root.right);
    }
}


