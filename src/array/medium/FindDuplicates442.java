package array.medium;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

/**
 * Created by Administrator on 2017/12/5.
 */
public class FindDuplicates442 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1,9,9};
        List<Integer> list = findDuplicates(nums);
        for(Integer i : list)
            System.out.print(i + "   ");

    }
    /* 空间复杂度0    时间复杂度o(n）
        思路：： 把该数组中   对应元素-1  为下标的元素取负值，当第二次在取负时变为正   则该元素出现2次
    * */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[abs(nums[i])-1] = -nums[abs(nums[i])-1] ;
            if( nums[abs(nums[i])-1]> 0)
                list.add(abs(nums[i]));
        }
        return list;
    }

    //需要o(n) 的空间
   /* public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] num = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            num[nums[i]-1]++;
        }
        for (int i = 0; i < num.length; i++) {
            if(num[i] == 2)
                list.add(i+1);
        }
        return list;
    }*/
}
