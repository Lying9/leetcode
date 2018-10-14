package array.easy;

/**
 * Created by Administrator on 2017/11/21.
 */
public class PivotIndex724 {
    public static void main(String[] args) {
       // int[] nums ={1, 7, 3, 6, 5, 6};
       // int[] nums ={1,2,3};
        int[] nums={-1,-1,-1,0,1,1};
        System.out.println(pivotIndex(nums));
    }
    //38ms
    public static int pivotIndex(int[] nums) {
        int sum=0;
        int tempSum=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        for(int i=0;i<nums.length;i++){
            tempSum += nums[i];
            if(sum==tempSum){
                return i;
            }
            sum-=nums[i];
        }
        return -1;
    }
    /*36ms
    * 思路：left左侧的和   right右侧的和
    *       求出 除下标为0的所有元素的和  即为i=0时的right
    *                                          如果right为0则 返回0
    *                                          否则 从i=1开始遍历整个数组 left每次加nums[i-1]  right每次－nums[i]
    *       注意返回0 和数组长度-1 的情况
    * */
   /* public static int pivotIndex(int[] nums) {
        if(nums==null || nums.length ==0)
            return -1;
        int left = 0,right = 0;
        for (int i = 1; i < nums.length ; i++) {
            right += nums[i];
        }
        if(right == 0)
            return 0;
        for (int i = 1; i < nums.length; i++) {
            left += nums[i-1];
            right -= nums[i];
            if(left == right)
                return i;
        }
        return -1;
    }*/
}
