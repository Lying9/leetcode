package array.medium;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/12/20.
 */
public class ProductExceptSelf238 {
    public static void main(String[] args) {
        int[] nums = {1,0};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    /*思路： 先计算出数组中所有除0以外的元素的乘积 并记录0的个数
            如果没有0    则output数组中值应该是总成绩除以nums[i]的值
            如果有一个0  则除了0元素位置的元素是总成绩外，其他元素均为0
            如果有大于1个的0  则所有元素均为0
    * */
    public static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int product = 1,countzero = 0,zeroindex = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!= 0)
                product *= nums[i];
            else {
                countzero++;
                zeroindex = i;
            }
        }
        if(countzero == 1) {
            output[zeroindex] = product;
            for (int i = 0; i < output.length; i++) {
                if(i != zeroindex)
                 output[i] = 0;
            }
        }
        else if(countzero > 1){
            for (int i = 0; i < output.length; i++) {
                output[i] = 0;
            }
        }else {
            for (int i = 0; i < output.length; i++) {
                output[i] = product / nums[i];
            }
        }
        return output;
    }
    /*
    * int[] result = new int[length];
        int temp = 1;
        //result数组中每个元素为前i-1的乘积
        for(int i = 0; i <length; i++)
        {
            result[i] = temp;
            temp *= nums[i];
        }

        temp = 1;
        //result数组中每个元素  在乘以本元素之后的所有元素的乘积   即为 除本身之外的乘积
        for(int i = length - 1; i >= 0; i--)
        {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    *
    * */
}
