package array.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/21.
 */
public class TriangleNumber611 {
    public static void main(String[] args) {
       //int[] nums = {2,2,3,4};
        int[] nums = {34,75,96,10,60,70,70,45};
        System.out.println(triangleNumber(nums));
    }
    //time limit exceeded
    /*public static int triangleNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                for (int k = j+1; k < nums.length ; k++) {
                    if(nums[i]+nums[j]>nums[k] && nums[k]+nums[i]>nums[j] && nums[k]+nums[j]>nums[i]){
                        sum ++;
                    }
                }
            }
        }
        return sum;
    }*/
    //二分查找  接受
   /* public static int triangleNumber(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2 ; i++) {
            for (int j = i+1; j < nums.length-1 ; j++) {
                int count = binarySearch(nums,j+1,nums.length-1,nums[i]+nums[j]);
                if(count -j-1 > 0)
                    sum+=count-j-1;
            }
        }
        return sum;
    }
    public static int binarySearch(int[] nums,int start,int end,int target){
        int low = start;
        int high = end;
        int mid;

        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] < target)
                low = mid +1;
            else if(nums[mid] > target)
                high = mid-1;
            else {
                while(mid > start && nums[mid-1] == target){
                    mid--;
                }
                return mid;
            }
        }
        return low;
    }*/
   public static int triangleNumber(int[] nums){
       Arrays.sort(nums);
       int k,sum=0;
       for (int i = 0; i < nums.length-2 ; i++) {
           k = i+2;
           for (int j = i+1; j < nums.length-1 ; j++) {
               while(k<nums.length && nums[i]+nums[j]>nums[k] ) {
                  // sum++;
                   k++;
               }
               sum += k - j - 1;
           }
       }
       return sum;

   }

}
