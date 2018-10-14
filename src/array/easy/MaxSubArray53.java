package array.easy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/21.
 */
public class MaxSubArray53 {

    public static void main(String[] args) {
       int[] nums={-2,1,-3,4,-1,2,1,-5,4};
       // int[] nums={-2,-1};
        System.out.println(maxSubArray(nums));
    }
/*
* 思路：  intermax表示前几项相加的和 判断当这个数为正则  加上 当前数  为负则 吧当前元素值赋值给intermax
* */
    public static int maxSubArray(int[] nums) {
        int max=nums[0];                    //holds the current max value
        int intermax=nums[0];              //holds the intermediate max value
        for(int i=1;i<nums.length;i++){
            if(intermax < 0){
                intermax=nums[i];
            }
            else{
                intermax = intermax+ nums[i];
            }
            if(intermax > max){
                max = intermax;
            }
        }
        return max;
    }

    //94ms
   /* public static int maxSubArray(int[] nums) {
        if(nums.length==0 || nums == null)
            return 0;
        int max = Integer.MIN_VALUE ,sum =0;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i; j < nums.length ; j++) {
                sum += nums[j];
                if(sum > max)
                    max =sum;
            }
            sum = 0;
        }
        return max;
    }*/
}
