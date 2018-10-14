package array.easy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/22.
 */
public class RemoveElement27 {
    public static void main(String[] args) {
        int[] nums={3,2,2,3,5,6,3,1,2,9};
        System.out.println(removeElement(nums,3));
    }
    /*
    * 思路：： 从后往前遍历整个数组  当当前元素与val相等时，判断 如果为数组最后一位则为他赋值0，如果不是则赋值为j的值（j为数组中最后一个不是val的数）
    *       效率不高，不如下面方法
     *  */
    public static  int removeElement(int[] nums, int val) {
        int j=nums.length-1,count =0 ;
        for (int i = nums.length-1; i >= 0 ; i--) {
            if(val == nums[i]){
                count++;
                if(i == nums.length-1){
                    nums[nums.length-1] =0;
                    j--;
                } else {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    j--;
                }
            }
        }
       // System.out.println(Arrays.toString(nums));
        return nums.length-count;
    }

    /**
     * 思路： 遍历整个数组 当当前元素与val相等时，把当前元素赋值为length-1所对应元素，length--
     *                                            否则 下标加1
     */

   /* int index = 0;
//length的初始值为nums.length
        while(index < length) {
        if (array[index] == element) {
            array[index] = array[length - 1];
            length--;
        } else {
            index++;
        }
    }
        return length;*/
}
