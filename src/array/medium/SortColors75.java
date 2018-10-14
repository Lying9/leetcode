package array.medium;

import java.util.Arrays;

/**
 * Created by ying on 2018/4/20.
 */
public class SortColors75 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
    //遍历数组  得到 0 1 2 的个数  然后在对数组赋值
   /* public static void sortColors(int[] nums) {
        int countz = 0,counto =0,countt =0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] ==0)
                countz++;
            else if(nums[i] ==1)
                counto++;
            else
                countt++;
        }
        for (int i = 0; i < countz ; i++) {
            nums[i] =0;
        }
        for (int i = countz; i < countz+counto ; i++) {
            nums[i] =1;
        }
        for (int i = countz+counto; i < nums.length ; i++) {
            nums[i] =2;
        }

    }*/

   /*从前往后遍历，如果遇到0  就与前面不为0 的 交换    需要一个变量记录 第一个不为0的下标
   *                   遇到1  指针往后移动
   *                   遇到2   就与后面第一个不为2的交换   需要一个变量来记录从后起第一个不为2的下标*/
    public static void sortColors(int[] nums) {
        int index =0 ,p0= 0,p2= nums.length-1;
        while(index < p2){
            if(nums[index] == 0){
                nums[index] = nums[p0];
                nums[p0] = 0;
                p0++;
            }
            if(nums[index] == 2){
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }
}
