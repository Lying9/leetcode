package jianzhioffer;

import java.util.LinkedList;

/**
 * Created by ying on 2019/3/15.
 */
public class KTree {
    private static int num = 0;

    public static void main(String[] args) {
      /*   String s = "8,6,10,5,7,9,11,#,#,#,#,#,#,#,#";
        TreeNode root = Deserialize(s);
        System.out.println(KthNode(root,1).val);*/
       String  s = "12";
       int temp = s.charAt(1)-'0';
        System.out.println(temp);
        StringBuilder sb  = new StringBuilder();

    }

   static  TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null)
            return null;
        TreeNode left = KthNode(pRoot.left, k);
        if(left != null)
            return left;
        num++;
        if (num == k)
            return pRoot;
       TreeNode right = KthNode(pRoot.right, k);
       return right;
    }
   static TreeNode Deserialize(String str) {
       if(str.length() == 0)
           return null;
       String[] strings = str.split(",");
       TreeNode root = new TreeNode(Integer.valueOf(strings[0]));
       LinkedList<TreeNode> list = new LinkedList<>();
       list.add(root);
       int index = 1;
       String s;
       while(list.size() >0){
           TreeNode temp = list.pollFirst();
           s = strings[index++];
           if("#".equals(s))
               temp.left = null;
           else{
               temp.left = new TreeNode(Integer.valueOf(s));
               list.add(temp.left);
           }
           s = strings[index++];
           if("#".equals(s))
               temp.right = null;
           else {
               temp.right = new TreeNode(Integer.valueOf(s));
               list.add(temp.right);
           }
       }
       return root;

   }
}
