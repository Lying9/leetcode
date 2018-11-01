package pickone.medium;

/**
 * Created by ying on 2018/10/31.
 */
public class PredictTheWinner486 {
    public static void main(String[] args) {
        int[] nums = {1,5,2};
        System.out.println(predictTheWinnerdp(nums));
    }
//思路：player1所获得的看成正数，player2获得的看成负数，则最后总和》=0 1获胜，否则1输
//    cache[i][j]表示的是当nums从i到j时所获得的最多的数
    public static boolean predictTheWinner(int[] nums) {
        int start = 0, end = nums.length - 1;
        Integer[][] cache = new Integer[nums.length][nums.length];
        predict(start, end, nums, cache);
        return cache[start][end] >= 0;
    }

    //    备忘录
    public static int predict(int start, int end, int[] nums, Integer[][] cache) {
        if (cache[start][end] == null)
            cache[start][end] = start == end ? nums[start] : Math.max(nums[start] - predict(start + 1, end, nums, cache), nums[end] - predict(start, end - 1, nums, cache));
        return cache[start][end];
    }

    //    DP
    public static boolean predictTheWinnerdp(int[] nums) {
        int[][] cache = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            cache[i][i] = nums[i];
        }
        for (int i = nums.length -2; i >=0 ; i--) {
            for (int j = i+1; j <nums.length ; j++) {
                cache[i][j] = Math.max(nums[i] - cache[i+1][j],nums[j] - cache[i][j-1]);
            }
        }
        return cache[0][nums.length-1]>=0;
    }
}
