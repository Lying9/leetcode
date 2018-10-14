package array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */
/*创建一个额外的数组  把传入数组中的值所对应的额外数组的下标处的值加1
遍历额外的数组 值为0的 数组下标 则为没有出现的值*/
public class FindDisappearedNumbers448 {
    public static void main(String[] args) {
       // int[] nums ={4,3,2,7,8,2,3,1};
        int[] nums ={1,1};
        List<Integer> list = findDisappeareNumber(nums);
        System.out.println(list.toString());
    }

    private static List<Integer> findDisappeareNumber(int[] nums) {
       /* List<Integer> list =new ArrayList<>();
        for (int i = 1; i <=nums.length ; i++) {
            list.add(i);
        }
        System.out.println(list.toString());
        for (int i = 0; i < nums.length; i++) {
                  list.remove((Object)nums[i]);
            System.out.println(list.toString());
        }

        return list;*/
        List<Integer> list =new ArrayList<>();
        int[] temp = new int[nums.length+1];
        for (int i = 0; i <nums.length; i++) {
            temp[nums[i]]++;
        }
        for (int i = 1; i <temp.length ; i++) {
            if(temp[i] == 0)
                list.add(i);
        }

        return list;
    }
}
