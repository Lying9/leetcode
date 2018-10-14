package array;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/10/30.
 */

/*  416
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

        Note:
        Each of the array element will not exceed 100.
        The array size will not exceed 200.
        Example 1:

        Input: [1, 5, 11, 5]

        Output: true

        Explanation: The array can be partitioned as [1, 5, 5] and [11].

        思路：1，对数组进行排序
              2，比较数组中最后一个值（最大值max）与前n-1个数之和(sum)
                    如果max < sum  则结果为false
                            =              true
                            >    则计算两者的差  如果差为奇数则结果为false，如果差为偶数则问题转化为在数组的前n-1中有没有几个数的和等于 差/2
              3, 解决在数组中有没有几个数的和等于 差/2
                    从第n-1开始 逐个往前遍历
                    如果改相比要找的数大，则进行下一项循环
                                       相等，返回TRUE
                                       小，则找该项之前的所有数中有没有和为  差/2-该项  的值（递归）  注意：：在这个中只有返回的是TRUE才能返回如果是FALSE则不能返回，还要进行下一次循环

*/
public class Solution {
    public static void main(String[] args) {
      //int[] nums = {1,5,11,5};//true
       // int[] nums = {1,2,3,5}; //false
       // int[] nums = {1,3,4,4};//false
      // int[] nums = {1,2,3,4,5,6,7};//true
        int[] nums = {71,70,66,54,32,63,38,98,4,22,61,40,6,8,6,21,71,36,30,34,44,60,89,53,60,56,73,14,63,37,15,58,51,88,88,32,80,32,10,89,67,29,68,65,34,15,88,8,57,78,37,63,73,65,47,39,32,74,31,44,43,4,10,8,96,22,58,87,29,99,79,13,96,21,62,71,34,55,72,3,96,7,36,64,30,6,14,87,12,90,40,13,29,21,94,33,99,86,4,100};
        boolean b = canPartition(nums);
        System.out.println(b);
    }

    public static boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length-1 ; i++) {
            sum += nums[i];
        }
        if (sum < nums[nums.length - 1])
            return false;
        else if (sum == nums[nums.length - 1])
            return true;
        else {
            int sub = sum - nums[nums.length - 1];
            if (sub % 2 == 1)
                return false;
            return find(nums, nums.length-2, sub / 2);
            //  return find(nums,nums.length-2,sum);

        }
    }
    public static Boolean find(int[] nums,int count,int target){
        for (int i = count; i >=0; i--) {
            if(nums[i]>target)
                continue;
            else if(nums[i]==target)
                return true;
            else {
                if (find(nums, i - 1, target - nums[i]))
                    return true;
            }
        }
        return false;
    }



}
