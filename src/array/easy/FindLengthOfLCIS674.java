package array.easy;

/**
 * Created by Administrator on 2017/11/20.
 */
/*
*   1.当数组长度为0或数组为null时        返回0
*   2.从i=1开始遍历整个数组 如果比前一个元素大则length++，否则与max进行比较 若比max大则赋值给max length赋值为1
*          （length 为当前递增数    max最大的递增数）
* */
public class FindLengthOfLCIS674 {

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        System.out.println(findLengthOfLCIS(nums));
    }
    //效率低  5ms
   /* public static  int findLengthOfLCIS(int[] nums) {
        if(nums.length==0 || nums==null)
            return 0;
        int start=0,max=0,i;
        for ( i = 1; i < nums.length ; i++) {
            if(nums[i] <= nums[i-1]){
                if(i-start > max)
                    max = i-start;
                start = i;
            }
        }
        if(i-start > max)
            max = i-start;
        return max;
    }
*/
    //效率高 4ms
    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length==0 || nums==null)
            return 0;
        int length =1,max=0;
        for (int i = 1; i < nums.length ; i++) {
            if(nums[i] > nums[i-1]){
                length++;
            }else{
                if(length > max)
                    max = length;
                length = 1;
            }
        }
        if(length > max)
            max = length;
        return max;

    }
}
