package pickone.eazy;


/**
 * Created by ying on 2018/10/24.
 */
public class DiameterOfBinaryTree543 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        System.out.println(diameterOfBinaryTree(a));
    }

    static int max;

    public static int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        depth(root);
        return max - 1;
    }

    //
    public static int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;

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
