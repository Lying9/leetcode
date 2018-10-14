package array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/27.
 */
public class ContainsNearbyDuplicate219 {

    public static void main(String[] args) {
       // int[] nums = {1,2,3,4,5,1,3,6,7,8,9,32,43};
       int[] nums = {99,99};
       // int[] nums = {1,2,3,4,5,6,7,8,9,9};
        System.out.println(containsNearbyDuplicate(nums,2));
    }
    /*
    * 思路：  用一个集合来存储k个数   因为集合不允许插入重复元素  所以当集合中已经有某元素时在插入会返回FALSE
    *
    * */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();//这个集合里存储 k  个数
        for (int i = 0; i < nums.length ; i++) {
            if(i > k)
                set.remove(nums[i-k-1]);
            if(!set.add(nums[i]))
                return true;
        }
        return false;
    }

    //超时
   /* public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j<nums.length &&j < i+k+1 ; j++) {
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }*/
}
