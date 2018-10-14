package array.easy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/23.
 */
public class PlusOne66 {

    public static void main(String[] args) {
        int[] digits = {9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
    /*
    从最后一位开始判断加1之后的和是不是10  （或者直接判断元素是不是9）
                是  则继续判断前一位
                不是   则跳出循环
            判断跳出循环时的下标  如果<0 则表示每一位都有进位  则在前加1 后面元素都为0  返回
                                   否则  返回数组

    * */
    public static int[] plusOne(int[] digits) {
        int i  = digits.length-1;
        while(i>=0 && ++digits[i] >=10){
                digits[i] = digits[i]%10;
                i--;
        }
        if(i < 0){
            int[] nums = new int[digits.length+1];
            nums[0] = 1;
            /*for (int j = 1; j <nums.length ; j++) {
                nums[j] = digits[j-1];
            }*/
            return nums;
        }else
            return digits;


    }
}
