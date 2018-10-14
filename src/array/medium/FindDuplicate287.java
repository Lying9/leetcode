package array.medium;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/12/28.
 */
public class FindDuplicate287 {
    public static void main(String[] args) {
        int[] nums = {1,4,6,6,6,2,3};
        System.out.println(findDuplicate((nums)));
    }

    public static int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
            System.out.println("t:"+tortoise+"  h:"+hare);
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

    /*先对数组进行排序，然后比较i和i+1 处的值
    * */
   /* public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -1 ; i++) {
            if(nums[i] == nums[i+1])
                return nums[i];
        }
        return 0;
    }*/
}
