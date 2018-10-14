package array.easy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/30.
 */
public class FindPairs532 {

    public static void main(String[] args) {
     //   int[] nums = {3, 1, 4, 1, 5};//  k=2   2
     //  int[] nums = {1, 2, 3, 4, 5};// k=1   4
       // int[] nums ={1, 3, 1, 5, 4}; //k=0 1
        int[] nums = {1,1,1,1,1};
        System.out.println(findPairs(nums,0));
    }
    public static  int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length ; i++) {
            int j = i+1;
            while(j<nums.length && nums[j] < nums[i]+k)
                j++;
            if(j == nums.length)
                continue;
            if(nums[j] == nums[i]+k)
                count++;
            int m = nums[i];
            while(i<nums.length-1 && m == nums[i+1]){
                i++;
            }
        }
        return count;
    }
}
