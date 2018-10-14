package array.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ying on 2018/4/23.
 */
public class MaximumSwap670 {
    public static void main(String[] args) {
      int num =5555524;
        System.out.println(maximumSwap(num));
    }
    public static int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {   //找比A[i]大的所有数的中 有没有下标在i之后的
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }
   /* public static int maximumSwap(int num) {
        Integer n = num;
        int length = n.toString().length();
        int[] nums = new int[length];
        int[] numssort = new int[length];
        int div =1;
        for (int i = 0; i < length-1 ; i++) {
            div *=10;
        }
        //把num的每一位放到数组中
        for (int i = 0; i < length; i++) {
            nums[i] = n / div;
            numssort[i] = n / div;
            n = n%div;
            div = div /10;
        }

      //  char[] A = Integer.toString(num).toCharArray();
       // Integer.valueOf(new String(A));   数组与字符数组之间的转换


        Arrays.sort(numssort);
        //numssort是正序的，而当nums是逆序时 num最大  所以找到num最头开始第一个不符合逆序的则是需要交换的数字
        int i=0;
        for ( i= 0; i <length ; i++) {
            if(nums[i]!=numssort[length-1-i])
                break;
        }
        //需要交换的情况
        if(i<length) {
            int temp = nums[i];
            nums[i] = numssort[length - 1 - i];

            for (int j = length - 1; j >= 0; j--) {
                if (nums[j] == numssort[length - 1 - i]) {
                    nums[j] = temp;
                    break;
                }
            }
            int result=0;
            div =1;
            for (  i = length-1; i >=0; i--) {
                result +=nums[i]*div;
                div *= 10;
            }
            return result;
        }

        return num;

    }*/
    //栈溢出   可能原因：迭代次数太多
  /*  public static int maximumSwap(int num) {
        Integer n = num;
        int length = n.toString().length();
        int[] nums = new int[length];
        int div =1,max =-1,index =-1,count=1;
        for (int i = 0; i < length-1 ; i++) {
            count *=10;
        }
        div = count;
        for (int i = 0; i < length; i++) {
            nums[i] = n / div;
            n = n%div;
            if(nums[i] > max){
                max = nums[i];
                index =i;
            }
            div = div /10;
        }
        if(index == 0)
            return nums[0]*count+maximumSwap(num%count);
        int temp = nums[index];
        nums[index] = nums[0];
        nums[0] = temp;

        int result=0;
        div =1;
        for (int i = length-1; i >=0; i--) {
            result +=nums[i]*div;
            div *= 10;
        }
       return result;
    }*/
}
