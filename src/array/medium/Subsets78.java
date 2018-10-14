package array.medium;

import java.util.*;

/**
 * Created by Administrator on 2018/1/10.
 */
/*
* 借鉴
* 思路;先加入空
*       每加入一个元素就把之前所找出的所有子段都加上这个元素
* */
public class Subsets78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> list = subsets(nums);
        for(List<Integer> l : list){
            for(Integer i : l){
                System.out.print(i+"  ");
            }
            System.out.println();
        }

    }

    public static  List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        Arrays.sort(S);
        for(Integer i : S){
            List<List<Integer>> tmp = new ArrayList<>();
            for(List l : res){
                List<Integer> a= new ArrayList<>(l);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }

        return res;
    }
  /*  public static  List<List<Integer>> subsets(int[] S) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<Integer>());

            Arrays.sort(S);
            for (int i : S) {
                List<List<Integer>> tmp = new ArrayList<>();
                for (List<Integer> sub : res) {
                    List<Integer> a = new ArrayList<>(sub);
                    a.add(i);
                    tmp.add(a);
                }
                res.addAll(tmp);
            }
            return res;
        }*/



   /* public static  List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return list;
        for (int i = 0; i <nums.length ; i++) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(nums[i]);
            list.add(list1);
        }
        for (int length = 2; length <= nums.length ; length++) {
            for (int frist = 0; frist < nums.length; frist++) {
                if(frist + length-1 < nums.length) {//以frist开头的可以有这个长度的
                    int second = frist+1;
                    while(second+length-2<nums.length) {
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(nums[frist]);
                        int end = second + length - 2;
                        int j = second;
                        while (j <= end && end < nums.length) {
                            list1.add(nums[j]);
                            j++;
                        }
                        second++;
                        list.add(list1);

                    }
                }


            }

        }
        List<Integer> list2  = new ArrayList<>();
        list.add(list2);
        return list;
    }*/

   /* public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //list.add(null);
        if(nums == null || nums.length == 0)
            return list;
       // System.out.println("tiaoyong subsets");
        for(int length = 1;length<=nums.length;length++){ //长度：元素个数
            for (int i = 0; i <nums.length ; i++) {   //第一个元素
                int k =i;
                while(k< nums.length){ //以那个开始
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    int j = k+1;
                    while(k+length-1< nums.length && j<=k+length-1-1){
                        list1.add(nums[j]);
                        j++;
                    }
                    if(list1!=null) {
                        list.add(list1);
                        for (Integer element : list1) {
                            System.out.print(element + "  ");
                        }
                        System.out.println();
                    }
                    k++;
                }



            }
        }
        return list;
        }*/

}
