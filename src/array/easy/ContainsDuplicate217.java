package array.easy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/16.
 */
public class ContainsDuplicate217 {

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,9};
        System.out.println(containsDuplicate(nums));
    }
    /*
    * 思路：先排序 ，在遍历 看后一个元素和当前元素一不一样    效率不如下一个
    * */
   /* public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }*/

   /*
   *  1.先找出数组的最大值与最小值
   *  2.创建一个长度为 max-min+1的布尔型数组  即数组长度为数组中所有可能出现的数的个数
   *  3.遍历数组  result中下标为 数组中数- 最小值
   * */
    public static boolean containsDuplicate(int[] nums) {
        if(nums.length ==0 || nums == null)
            return false;
        int minNum = nums[0];
        int maxNum = nums[0];
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] > maxNum)
                maxNum = nums[i];
            if(nums[i] < minNum)
                minNum = nums[i];
        }
        if(minNum == maxNum) return true;
        if(maxNum-minNum+1 > nums.length)
            return true;
        boolean[] result = new boolean[maxNum-minNum+1];
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - minNum;
            if(result[index])
                return true;
            else
                result[index] = true;
        }
        return  false;
    }
}
