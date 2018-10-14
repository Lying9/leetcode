package array.medium;

import org.omg.CORBA.INTERNAL;

/**
 * Created by ying on 2018/5/8.
 */
public class MaxChunksToSorted769 {
    public static void main(String[] args) {
        //int[] nums = {1,0,2,3,4};//4
        // int[] nums = {0};  //1
        //int[] nums = {0,2,1};
        int[] nums = {1, 4, 3, 6, 0, 7, 8, 2, 5};//1
        System.out.println(maxChunksToSorted2(nums));
    }

    /*
    * 思路：  分块的条件： 该块中的最小元素  >  前一块中的最大元素
    *                      该块中的最大元素  <  后一块中的最小元素
    *         因为数组中存储的数为：[0.,,,arr.length-1]
    *         所以分块的条件为     该块中的最小元素=这一块的开始下标，该块的最大元素=当前遍历的下标（即遍历过的元素个数）
    *
    *  优化： 其实分块只要保证   该块的最大元素=当前遍历的下标  即可
    * */
    public static int maxChunksToSorted(int[] arr) {
        int start = 0, count = 0, min = Integer.MAX_VALUE, max = -1;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
            if (min == start && max == i) {
                count++;
                start = max + 1;
                min = Integer.MAX_VALUE;
                max = -1;
            }
        }
        return count;
    }

    //    优化
    public static int maxChunksToSorted2(int[] arr) {
        int count = 0, max = -1;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (max == i) {
                count++;
            }
        }
        return count;
    }
}
