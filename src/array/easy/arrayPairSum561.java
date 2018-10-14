package array.easy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/2.
 */
public class arrayPairSum561 {
    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        int result =  arrayPairSum(nums);
        System.out.println(result);
    }
    /*排序时间复杂度 o(nlogn)
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i <nums.length ; i+=2) {
            sum += nums[i];
        }
        return sum;
    }*/

    //o(n)
    public static int arrayPairSum(int[] nums) {
        int[] buckets = new int[20001];
        for (int i=0; i<nums.length; i++) {
            nums[i] = nums[i] + 10000;
            buckets[nums[i]]++;
        }

        int sum = 0;
        boolean first = true;
        for (int i=0; i<buckets.length; i++) {
            if (buckets[i] == 0) continue;

           while (buckets[i] > 0) {
                if (first) {
                    sum += (i - 10000);
                    first = false;
                }
                else {
                    first = true;
                }
                buckets[i]--;
            }//while是为了解决相同数字的情况
        }

        return sum;
    }

}
