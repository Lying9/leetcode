package pickone.medium;

import java.util.*;

public class Rermute46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = permute(nums);
        for(List<Integer> l : list){
            System.out.println(l);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0)
            return null;
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,0,nums.length-1,result);
        return result;
    }
    public static void helper(int[] nums, int start, int end,  List<List<Integer>> result){
        if(start == end){
            List<Integer> list = arrayToList(nums);
            result.add(list);
        }
        for (int i = start; i <= end ; i++) {
            swap(nums,i,start);
            helper(nums,start+1,end,result);
            swap(nums,i,start);
        }
    }

    public static List<Integer> arrayToList(int[] nums){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            list.add(nums[i]);
        }
        return list;
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
