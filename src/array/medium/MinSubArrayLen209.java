package array.medium;

/**
 * Created by ying on 2018/9/4.
 */
public class MinSubArrayLen209 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(minSubArrayLen(s, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
// 1.动态规划  Memory Limit Exceeded
       /* if(nums == null)
            return 0;
        int minlength = Integer.MAX_VALUE;
        int[][] sum = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length ; i++) {
            sum[i][i] = nums[i];
            if(nums[i] >= s)
                return 1;
        }
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                sum[i][j] = sum[i][j-1] + nums[j];
                if(sum[i][j]>=s)
                    minlength = Math.min(minlength,j-i+1);
            }
        }
        if(minlength == Integer.MAX_VALUE )
            minlength = 0;
        return minlength;*/

//       2. 求连续的和，如何超过s就从序列的开头减去元素  accept
//        答案中的方法与我的思路一样，只是 人家用left和right来记录序列，少了些计算
        int minlength = Integer.MAX_VALUE, sum = 0, length = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            length++;
            while (sum >= s) {
                minlength = Math.min(minlength, length);
                sum -= nums[i - length + 1];
                length--;
            }
        }
        if(minlength == Integer.MAX_VALUE )
            minlength = 0;
        return minlength;
    }
}
