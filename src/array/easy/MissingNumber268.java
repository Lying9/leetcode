package array.easy;

/**
 * Created by Administrator on 2017/11/18.
 */
public class MissingNumber268 {

    public static void main(String[] args) {
        int[] nums = {0,1,3};
        System.out.println(missingNumber(nums));
    }
    /*
    *   思路：用另一个数组来实现 这个数组中存放的是nums中出现数的个数
    *           则该数组中为0值的即是缺少的那个数
    * */
   /* public static int missingNumber(int[] nums) {
        int[] temp = new int[nums.length+1];
        for (int i = 0; i < nums.length ; i++) {
            temp[nums[i]]++;
        }
        int i=0;
        while(temp[i] >0){
            i++;
        }
        return i;
    }*/
   /*   思路：求前n项和  和  nums数组中元素和的差  即为数组中缺少的数
   * */
    public static int missingNumber(int[] nums) {
        int result = 0;
        for (int i:nums) {
            result += i;
        }
        result = (nums.length+1)*nums.length/2 - result;
        return result;
    }
}
