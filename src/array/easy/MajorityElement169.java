package array.easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/14.
 */
public class MajorityElement169 {

    public static void main(String[] args) {
        int[] nums = {1,8,1,3,8,4,8,5,6,8,8,8,8};
        System.out.println(majorityElement(nums));
    }

    /*
    * 思路： 先对 数组进行排序   排序时间复杂度 nlog(n)  4ms
    *         数组长度为偶   判断当前元素下标+n/2-1  是不是和当前元素一样    n为数组的长度
    *                   奇                   +n/2
    * */
   /* public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int i=0,num;
        if(nums.length%2 ==0) {
            while (i < nums.length) {
                if (nums[i + nums.length/2 -1] == nums[i])
                    return  nums[i];
                else
                    i++;
            }
        }
        else{
            while (i < nums.length) {
                if (nums[i + nums.length/2 ] == nums[i])
                    return  nums[i];
                else
                    i++;
            }
        }
        return -1;
    }*/
   //36ms
   /* public static int majorityElement(int[] nums) {
        int n=0;
        if(nums.length%2 ==0)
            n = nums.length/2;
        else n = nums.length/2 +1;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                if(map.get(nums[i])>=n)
                    return nums[i];
            }
            else
                map.put(nums[i],1);
        }

      *//*  for(Integer i : map.keySet()){
            if(map.get((Object)i) >= n )
                return i;
        }*//*
        return -1;
    }*/
    public  static int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                count++;
                cur = nums[i];
            }else if(cur == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return cur;
    }
}
