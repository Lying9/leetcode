package test;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by ying on 2019/4/29.
 */
public class TreeSort {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        //TreeNode t7 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;

//        前序递归  0  1 3 4 2 5 6
        //qianxudigui(root);
        //前序非递归
        //  qianxufeidigui(root);
        //中序递归  3  1  4  0  5  2  6
//        zhongxudigui(root);
//         中序非递归
        // zhongxufeidigui(root);
        //后序递归
        // houxudigui(root);
        houxufeidigui(root);
    }

    /**
     * 前序递归
     */
    public static void qianxudigui(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + "   ");
        qianxudigui(node.left);
        qianxudigui(node.right);
    }

    /**
     * 前序非递归
     */
    public static void qianxufeidigui(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        if (node != null)
            stack.add(node);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.val + "  ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null)
                stack.push(temp.left);
        }
    }

    /**
     * 中序递归
     */
    public static void zhongxudigui(TreeNode node) {
        if (node == null)
            return;
        zhongxudigui(node.left);
        System.out.print(node.val + "  ");
        zhongxudigui(node.right);
    }


    /**
     * 中序非递归
     */
    public static void zhongxufeidigui(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                TreeNode n = stack.pop();
                System.out.print(n.val + " ");
                node = n.right;
            }
        }
    }

    /**
     * 后序递归
     */
    public static void houxudigui(TreeNode node) {
        if (node == null)
            return;
        houxudigui(node.left);
        houxudigui(node.right);
        System.out.print(node.val + " ");
    }

    /**
     * 后序非递归
     */
    public static void houxufeidigui(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

        if (node != null) {
            stack.push(node);
            map.put(node, 1);
        }
        while (!stack.empty()) {
            TreeNode temp = stack.peek();
            if (map.get(temp) == 1) {
                if (temp.right != null) {
                    stack.push(temp.right);
                    map.put(temp.right, 1);
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                    map.put(temp.left, 1);
                }
                map.put(temp, 2);
            } else {
                System.out.print(temp.val + "  ");
                stack.pop();
                map.remove(temp);
            }
        }
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
