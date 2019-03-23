package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by ying on 2019/3/15.
 */
public class TreeZhi {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        if(pRoot == null)
            return result;
        LinkedList<TreeNode> list = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        list.add(pRoot);
        int length= 0;
        while(list.size() >0){
            length = list.size();
            for(int i =0;i<length;i++){
                TreeNode temp = list.pollFirst();
                arrayList.add(temp.val);
                if(temp.left!= null)
                    list.addLast(temp.left);
                if(temp.right!=null)
                    list.addLast(temp.right);
            }
            length = list.size();
            if(length <= 0)
                break;
            for(int i=0;i< length;i++){
                TreeNode temp = list.pollLast();
                arrayList.add(temp.val);
                if(temp.right!=null)
                    list.addFirst(temp.right);
                if(temp.left!= null)
                    list.addFirst(temp.left);
            }
        }
        result.add(arrayList);
        return result;
    }
}
