package array.easy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/15.
 */
public class TwoSum167 {

    public static void main(String[] args) {
       // int[] numbers = {2,7,11,5};
        int[] numbers = {5,25,75};
        System.out.println(Arrays.toString(twoSum(numbers,100)));
    }
  /*  public static  int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length ; i++) {
            int k = target - numbers[i];
            int index = Arrays.binarySearch(numbers,k);
            if(index >0 && index!=i){
                result[0] = Integer.min(i+1,index+1);
                result[1] = Integer.max(i+1,index+1);
                break;
            }
           *//* for(int j =i+1;j<numbers.length;j++){
                if(numbers[j] == k){
                    result[0] = i+1;
                    result[1] = j+1;
                    return result;
                }
                else if(numbers[j] > k)
                    break;
            }*//*

        }
        return result;
    }
*/
    public static  int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[2];
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] > target) {
                // move end forward to the last value that numbers[end] <= target - numbers[start]
                end = largestSmallerOrLastEqual(numbers, start, end, target - numbers[start]);
            } else {
                // move start backword to the first value that numbers[start] >= target - numbers[end]
                start = smallestLargerOrFirstEqual(numbers, start, end, target - numbers[end]);
            }
        }
        return new int[2];
    }
    private static int largestSmallerOrLastEqual(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
    private static int  smallestLargerOrFirstEqual(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
