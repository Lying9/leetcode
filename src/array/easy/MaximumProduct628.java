package array.easy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/18.
 */
/*
* 思路：找到数组中的 前三个数  和 后两个数
 *      当数组中全为大于0或全为小于0的数时   最大为前三个数之积
 *      当有正有负时  最大为 最大三个数 和最小两个与最大一个的乘积  中大的那个
 *       */
public class MaximumProduct628 {

    public static void main(String[] args) {
        int[] nums = {-1,-5,2,6,-3};
        System.out.println(maximumProduct(nums));
    }
    public static  int maximumProduct(int[] nums) {
        if(nums.length == 3)
            return nums[0]*nums[1]*nums[2];
       /* Arrays.sort(nums);
        if(nums[0] >0 ||nums[nums.length-1] <0){
            return nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        }else
            return Integer.max(nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3],nums[0]*nums[1]*nums[nums.length-1]);*/
        int max1= -1001,max2 = -1001, max3 = -1001,min1 = 1001, min2 =1001;
        for (int i = 0; i < nums.length ; i++) {
                if (nums[i] >= max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = nums[i];
                } else if (nums[i] >= max2) {
                    max3 = max2;
                    max2 = nums[i];
                } else if (nums[i] >= max3) {
                    max3 = nums[i];
                }
                if (nums[i] <= min1) {
                    min2 = min1;
                    min1 = nums[i];
                } else if (nums[i] <= min2) {
                    min2 = nums[i];
                }
                }
                if(min1>0 ||max1<0)
                    return  max1*max2*max3;
                else
                    return Integer.max(max1*max2*max3,min1*min2*max1);

        }

   /* public static  int maximumProduct(int[] nums) {
        if(nums.length == 3)
            return nums[0]*nums[1]*nums[2];
        int negative = 0,positive =0,zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                positive++;
            else if(nums[i] < 0)
                negative++;
            else zero++;
        }
        int[] pos = new int[positive];
        int[] neg = new int[negative];
        int j=0,k=0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] > 0){
                pos[j++] = nums[i];
            }else if(nums[i] < 0)
                neg[k++] = nums[i];
        }
        Arrays.sort(pos);
        Arrays.sort(neg);
        if(positive==0){
            if(zero >0)
                return 0;
            else
                return neg[negative-1]*neg[negative-2]*neg[negative-3];
        }else if(positive ==1||positive==2){
            if(negative>= 2)
                 return pos[positive-1]*neg[0]*neg[1];
            else
                return 0;
        }else if(positive>2){
            if(negative>=2)
                return Integer.max(pos[positive-1]*pos[positive-2]*pos[positive-3],pos[positive-1]*neg[0]*neg[1]);
            else
                return pos[positive-1]*pos[positive-2]*pos[positive-3];
        }
        return 0;
*/


       /* int max1= -1001,max2 = -1001, max3 = -1001, maxn=-1001,min1 = 1001, min2 =1001;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] >= 0){
                if(nums[i]>=max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = nums[i];
                }else if(nums[i] >= max2){
                    max3 = max2;
                    max2 = nums[i];
                }else if(nums[i] >= max3){
                    max3 = nums[i];
                }
            }else{
                if(nums[i] <=min1){
                    min2 = min1;
                    min1 = nums[i];
                }else if(nums[i] <= min2) {
                    min2 = nums[i];
                }else if(nums[i] > maxn){
                    maxn = nums[i];
                }
            }
        }*/


   // }

}
