package jianzhioffer;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by ying on 2019/3/4.
 */
public class TreeTarget {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3= new TreeNode(7);
        TreeNode t4 = new TreeNode(12);
        root.left = t1;
        root.right = t4;
        t1.left = t2;
        t1.right = t3;
        ArrayList<ArrayList<Integer>> result = FindPath(root,22);
        for(ArrayList<Integer> a : result){
            for(Integer i : a){
                System.out.print(i + "   ");
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        if(root == null)
            return result;
        list.add(root);
        dfs(list,target,result);
        result.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size() > o2.size())
                    return -1;
                else if(o1.size() < o2.size())
                    return 1;
                else
                    return 0;
            }
        });
        return result;
    }
    public static void dfs(ArrayList<TreeNode> list,int target,ArrayList<ArrayList<Integer>> result){
        TreeNode t = list.get(list.size()-1);
        if(t.left == null && t.right == null && target == t.val){
            ArrayList<Integer> templist = new ArrayList<>();
            for(TreeNode tn : list)
                templist.add(tn.val);
            result.add(templist);
            return;
        }
        if(t.left != null){
            list.add(t.left);
            dfs(list,target-t.val,result);
            list.remove(list.size()-1);
        }
        if(t.right != null){
            list.add(t.right);
            dfs(list,target-t.val,result);
            list.remove(list.size()-1);
        }

    }
}


/*class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }*/

