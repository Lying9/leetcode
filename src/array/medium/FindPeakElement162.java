package array.medium;

/**
 * Created by ying on 2018/4/20.
 */
public class FindPeakElement162 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(findPeakElement(nums));
    }

    public  static   int findPeakElement(int[] nums) {

        for (int i = 0; i < nums.length-1 ; i++) {
            if(nums[i] > nums[i+1])
                return i;
        }
        return nums.length-1;
    }
}
