package array.easy;

/**
 * Created by Administrator on 2017/12/1.
 */
public class ThirdMax414 {
    public static void main(String[] args) {
        int[]  nums = {1,2,2};
        System.out.println(thirdMax(nums));
    }

    public static  int thirdMax(int[] nums) {
        long[]  max = new long [3];
        for (int i = 0; i < 3; i++) {
            max[i] =Long.MIN_VALUE;
        }
        boolean flag = false;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] == max[0] || nums[i] == max[1] || nums[i] == max[2])
                continue;
            if(max[2] < nums[i]){
                max[0] = max[1];
                max[1] = max[2];
                max[2] = nums[i];
            }else if(max[1] < nums[i]){
                max[0] = max[1];
                max[1] = nums[i];
            }else if(max[0] < nums[i]) {
                max[0] = nums[i];
            }
        }
        if(max[0] == Long.MIN_VALUE)
            return (int)max[2];
        else
            return (int)max[0];
    }
}
