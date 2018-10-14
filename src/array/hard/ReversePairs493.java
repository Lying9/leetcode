package array.hard;

/**
 * Created by ying on 2018/5/7.
 */
/*未解决 */
public class ReversePairs493 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};//2
       int[] nums1= {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePairs(nums1));
    }

//    time limited exceed
  /*  public static int reversePairs(int[] nums) {
        int count = 0,div = 0;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]%2==0)
                div = nums[i]/2;
            else
                div = nums[i]/2+1;
            for(int j = i+1;j<nums.length;j++){
//                if(nums[i]>2*nums[j])   //最大值  32位存储不下
                if(div > nums[j])
                    count++;
            }
        }
        return count;
    }*/
    public static int reversePairs(int[] nums) {
       return 0;
    }
}
