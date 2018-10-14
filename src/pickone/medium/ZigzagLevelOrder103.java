package pickone.medium;

import java.util.*;

/**
 * Created by ying on 2018/9/13.
 */
public class ZigzagLevelOrder103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode s1 = new TreeNode(2);
        TreeNode s2 = new TreeNode(4);
        TreeNode s3 = new TreeNode(1);
        TreeNode s4 = new TreeNode(3);
        TreeNode s5= new TreeNode(-1);
        TreeNode s6= new TreeNode(5);
        TreeNode s7 = new TreeNode(1);
        TreeNode s8 = new TreeNode(6);
        TreeNode s9 = new TreeNode(8);

        root.left = s1;
        root.right = s2;
        s1.left = s3;
        s2.left = s4;
        s2.right = s5;
        s3.left = s6;
        s3.right = s7;
        s4.right = s8;
        s5.right = s9;
        List<List<Integer>> result = zigzagLevelOrder(root);
        for (List list : result) {
            for (Object i : list) {
                System.out.print((Integer) i + "\t");
            }
            System.out.println();
        }
    /*  List<Integer> list =new ArrayList<>();
      list.add(1);
      list.add(2);
      list.remove(0);
      list.add(3);
      for(Object i : list){
          System.out.println((int)i);
      }*/

       /* TreeNode s5 = new TreeNode(9);
        TreeNode s6 = new TreeNode(9);*/
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode node, List<List<Integer>> res, int lvl){
        if(node==null)
            return;
        if(lvl==res.size())
            res.add(new ArrayList<>());

        if(lvl%2==1)
            res.get(lvl).add(0,node.val);
        else
            res.get(lvl).add(node.val);

        dfs(node.left, res, lvl+1);
        dfs(node.right, res, lvl+1);
    }



//第一次实现  accept
    /*可改进的地方：一、level 可用一个Boolean类型的运算代替  二、for和if的位置可以换
    * */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int level = 2, count = 1, levelcount = 1;
        List<TreeNode> deque = new ArrayList<>();
        deque.add(root);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        result.add(list);
        while (deque.size() > 0) {
            List<Integer> list1 = new ArrayList<>();
            TreeNode node;
            count = levelcount;
            levelcount = 0;
            for (int i = 0; i < count; i++) {
                if (level % 2 == 0) {
                    node = deque.remove(count-i-1);
                    if (node.right != null) {
                        list1.add(node.right.val);
                        deque.add(node.right);
                        levelcount++;
                    }
                    if (node.left != null) {
                        list1.add(node.left.val);
                        deque.add(node.left);
                        levelcount++;
                    }
                } else {
                    node = deque.remove(count-i-1);
                    if (node.left != null) {
                        list1.add(node.left.val);
                        deque.add(node.left);
                        levelcount++;
                    }
                    if (node.right != null) {
                        list1.add(node.right.val);
                        deque.add(node.right);
                        levelcount++;
                    }

                }
            }
            level++;
            if (list1.size()>0)
                result.add(list1);
        }

        return result;
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
