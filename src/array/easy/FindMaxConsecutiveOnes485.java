package array.easy;

/**
 * Created by Administrator on 2017/11/5.
 */
//找0的下标  计算其中间元素的个数  当为1 则说明前面的数为0 更改其数值  若>1 则为中间连续1的个数  这种比下面的实现更有效率
public class FindMaxConsecutiveOnes485 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int max = findMaxConsecutiveOnes(nums);
        System.out.println(max);
    }


    private static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0,count;
        int i=0;
        while(i<nums.length){
            count =0;
            while( i<nums.length && nums[i] == 1){
                i++;
                count++;
            }
            i++;
            if(count > max)
                max = count;
        }
        return  max;
    }
}
