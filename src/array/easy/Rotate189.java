package array.easy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/12/2.
 */
public class Rotate189 {
    public static void main(String[] args) {
        int[] nums  = {1,2,3,4,5,6,7,8,9};
        rotate(nums,3);
     /*   int[] nums = {1, 2};
        rotate(nums, 1);*/
    }
    public static void rotate(int[] nums, int k) {
        if (k == 0 || nums.length == 1)
            return;
        k = k%nums.length;
       int temp ,next=0,pre,count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            pre = nums[start];
            do {
                next = (current + k) % nums.length;
                temp = nums[next];
                nums[next] = pre;
                pre = temp;

                current = next;
                count++;
            }while(start!=current);
        }


        System.out.println(Arrays.toString(nums));
    }

   /* public static void rotate(int[] nums, int k) {
        if (k == 0 || nums.length == 1)
            return;
        int[] numsk = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsk[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsk[i];
        }

            System.out.println(Arrays.toString(nums));
    }*/

}

