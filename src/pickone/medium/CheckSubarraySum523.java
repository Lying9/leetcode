package pickone.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ying on 2018/10/23.
 */
public class CheckSubarraySum523 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        int k = 0;
        System.out.println(checkSubarraySum(nums, k));
    }
//思路：用一个map来存储余数和下标   当出现相同余数时，如果和上一个出现下标的差》1 说明这两个下标之间的数的和能整除k
    public static boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

    //两层循环
    public static boolean checkSubarraySum2(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (k == 0) {
                    if (sum == 0)
                        return true;
                } else if (sum % k == 0)
                    return true;
            }
        }
        return false;
    }


    // Memory Limit Exceeded     dp算法
    public static boolean checkSubarraySum1(int[] nums, int k) {
        int[][] sum = new int[nums.length][nums.length];
        for (int i = 0; i < sum.length; i++) {
            sum[i][i] = nums[i];
        }
        for (int step = 1; step < sum.length; step++) {
            for (int i = 0; i + step < sum.length; i++) {
                sum[i][i + step] = sum[i][i + step - 1] + nums[i + step];
                if (k == 0) {
                    if (sum[i][i + step] == 0)
                        return true;
                } else if (sum[i][i + step] % k == 0)
                    return true;
            }
        }
        return false;
    }
}
