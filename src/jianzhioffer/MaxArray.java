package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by ying on 2019/3/6.
 */
public class MaxArray {

    public static void main(String[] args) {
//        int[] array = {1,-2,3,10,-4,7,2,-5};
        int[] array = {-2,-8,-1,-5,-9};

        System.out.println(FindGreatestSumOfSubArray(array));
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0)
            return 0;
        if(array.length == 1)
            return array[0];
        int sum = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(sum < 0)
                sum = array[i];
            else
                sum += array[i];

            max = Integer.max(sum, max);
        }
        return max;
    }
}
