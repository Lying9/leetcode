package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by ying on 2019/3/6.
 */
public class MinK {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        Integer[] a = new Integer[list.size()];
        list.toArray(a);
        for(int i:a)
            System.out.println(i);

    /*    int[] input = {4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> result =  GetLeastNumbers_Solution(input,k);
        for(int i:result)
            System.out.println(i);*/

    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input.length == 0 || input.length < k)
            return null;
        ArrayList<Integer> result = new ArrayList<>();
       /* if(input.length <= k){
            for(int i : input)
                result.add(i);
            return result;
        }*/

        int low = 0,high = input.length-1 ;
        int index = partition(input,low,high);
        while(index != k){
            if(index > k)
                high = index-1;
            else
                low =index+1;
            index = partition(input,low,high);
        }
        for(int i = 0;i<k;i++){
            result.add(input[i]);
        }
        return result;
    }
    public static int partition(int[] nums,int low,int high){
        int temp = nums[high];
        while(low < high){
            while(low < high&&nums[low] <= temp)
                low++;
            nums[high] = nums[low];
            while(low < high&&nums[high] >= temp)
                high--;
            nums[low] = nums[high];
        }
        nums[high] = temp;
        return high;
    }
}
