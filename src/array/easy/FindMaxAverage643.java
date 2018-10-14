package array.easy;

/**
 * Created by Administrator on 2017/11/24.
 */
public class FindMaxAverage643 {

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums,4));
    }
    /*
    * 思路：1.计算出前k项和
    *       2.从下标为k的元素开始遍历，每次和为减去i-k元素加上i元素    找出最大值即可
    * */
    public static  double findMaxAverage(int[] nums, int k) {
        int max ,sum = 0;
        for (int i = 0; i < k  ; i++) {
            sum += nums[i];
        }
            max =sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i-k];
            if(max < sum)
                max =sum;
        }
        return (double)max/k;
    }
}
