package pickone.medium;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ying on 2018/10/31.
 */
public class FindBottomLeftValue513 {

    public static void main(String[] args) {
       /* List<Integer> list = new ArrayList<>();
        System.out.println(list == null);   //false
        list.add(1);
        list.add(2);
        list.clear();
        System.out.println(list == null);*/  //false
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
//        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(8);
        root.left = a;
        root.right = b;
        a.left = c;
        b.left = d;
        b.right = e;
//        d.left = f;
        d.right = g;
        System.out.println(findBottomLeftValue(root));

    }

//    思路：用递归的方法找出层数最大且在最左边的数   5ms
    static int prelevel;
    static int left;
    public static int findBottomLeftValue(TreeNode root) {
        prelevel = 0;
        left = root.val;
        findleft(prelevel,root);
        return left;
    }
    public static void findleft(int level,TreeNode root){
//        先左后右   顺序很重要
        if(root.left!=null)
            findleft(level+1,root.left);
        if(root.right!=null)
            findleft(level+1,root.right);
        if(level > prelevel ){
            prelevel = level;
            left = root.val;
        }
    }
//accept 思路：设置两个list 每一个list存储tree的一层 当某一层的所有节点都无左右孩子时，说明这一层是树的最后一层，则这个list中最左元素就是结果
//    时间复杂度：O(n) n:树的结点个数   空间复杂度：o(n) n:树的结点个数
//    缺点：代码有重复    7ms
     public static int findBottomLeftValue1(TreeNode root) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        list1.add(root);
        while (true) {
            if (list2.size() == 0) {
                for (TreeNode t : list1) {
                    if (t.left != null)
                        list2.add(t.left);
                    if (t.right != null)
                        list2.add(t.right);
                }
                if (list2.size() == 0)
                    return list1.get(0).val;
                list1.clear();
            } else {
                for (TreeNode t : list2) {
                    if (t.left != null)
                        list1.add(t.left);
                    if (t.right != null)
                        list1.add(t.right);
                }
                if (list1.size() == 0)
                    return list2.get(0).val;
                list2.clear();
            }
        }
    }
}
