package hashTable.easy;

/**
 * Created by ying on 2018/5/7.
 */
public class SingleNumber136 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,3};
        System.out.println(singleNumber(nums));
    }
    /*  要求： nums中 除一个数外，其他每个数出现两次   找出只出现一次的这个数
               要求在线性时间复杂度内  且在o(1)内存中
         方法：  求全部元素的异或    则结果就是出现一次的那个数
                 a^a = 0    0^a = a*/
    public static int singleNumber(int[] nums){
        int ele = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ele = ele ^ nums[i];
        }
        return ele;
    }
}
