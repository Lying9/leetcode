package array.easy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/8.
 */
//思路  1 把不是0的元素 从数组头开始赋值给数组，因为会按顺序所以覆盖的只是0
    //  2 数组中剩余元素赋值为 0
public class MoveZeroes283 {
    public static void main(String[] args) {
        int[] nums ={0,1,0,3,12};
        moveZeroes(nums);
    }

    private static void moveZeroes(int[] nums) {
        //加判断  提高效率
        if(nums.length==0 || nums ==null)
            return;
        int index=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i <nums.length ; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
