package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ying on 2018/4/25.
 */
public class SubsetsWithDup90 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> list = new ArrayList<>();
        list = subsetsWithDup(nums);
        for(List<Integer> l : list){
            for(Integer i : l){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
        //System.out.println(list.size());
    }
    /*思路：递归逐个遍历   再消除重复*/
    public  static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0,list,l);
        return list;
    }
    public static void dfs(int[] nums, int start,List<List<Integer>> list,List<Integer> l){
        //插入l
        List<Integer> li = new ArrayList<>(l);
        list.add(li);
        for (int i = start; i < nums.length ; i++) {
            //去重复 和下面效果一样
           // if(i != start && nums[i] == nums[i-1]) continue;

            l.add(nums[i]);
            dfs(nums,i+1,list,l);
            //去掉重复
            int temp = l.get(l.size()-1);
            while(i+1<nums.length && temp == nums[i+1])
                i++;
            l.remove(l.size()-1);
        }
    }
}
