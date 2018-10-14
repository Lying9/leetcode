package array.easy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/26.
 */
public class RemoveDuplicates26 {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,4,6};
        System.out.println(removeDuplicates(nums));
    }
    public static  int removeDuplicates(int[] nums) {
        int i =1;
        while(i<nums.length&&nums[i] != nums[i-1]){
            i++;
        }
        for (int j = i; j < nums.length-1 ; j++) {
            if(nums[j+1] != nums[i-1])
                nums[i++] = nums[j + 1];
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }
}
