package array.easy;

import java.util.*;

/**
 * Created by Administrator on 2017/11/13.
 */
/*
*   思路：1.找到数组中出现最多的次数
*          2.找到出现最多次数的  数
*          3.找到出现次数最多的数 在数组中的第一个和最后一个位置   则该段长度为最后-第一个+1   选出最小的
* */
public class FindShortestSubArray697 {

    public static void main(String[] args) {
        //int[] nums = {1, 2, 2, 3, 1};
        int[] nums = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(nums));
    }

  /*  public static int findShortestSubArray(int[] nums) {
        if(nums.length==0 || nums ==null)
            return 0;
        Map<Integer,Integer>  map = new HashMap<>();
      //  List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else
                map.put(nums[i],1);
        }
        int degree = 0,key = -1;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() > degree) {
                degree = entry.getValue();
            }
        }
        if(degree == 1)
            return 1;
        int small =Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() == degree) {
              // list.add(entry.getKey());
                key = entry.getKey();
                int i=0,j=nums.length-1;
                while(i<nums.length){
                    if(nums[i] == key)
                        break;
                    i++;
                }
                while(j>0){
                    if(nums[j] == key)
                        break;
                    j--;
                }
                if(j-i+1 < small)
                    small = j-i+1;
            }
        }
       *//* int small =Integer.MAX_VALUE;
        Iterator it= list.iterator();
        while(it.hasNext()){
            key = (Integer) it.next();
            int i=0,j=nums.length-1;
            while(i<nums.length){
                if(nums[i] == key)
                    break;
                i++;
            }
            while(j>0){
                if(nums[j] == key)
                    break;
                j--;
            }
            if(j-i+1 < small)
                small = j-i+1;
        }*//*
        return  small;


    }
*/
    public static int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxNum = 0;
        for (int n : nums) {
            maxNum = Math.max(n, maxNum);
        }

        int[] start = new int[maxNum + 1];
        int[] end = new int[maxNum + 1];
        int[] que = new int[maxNum + 1];

        for (int i = 0; i < nums.length; i++) {
            if (que[nums[i]] == 0)
                start[nums[i]] = i;
            end[nums[i]] = i;
            que[nums[i]]++;
        }

        int max = 0;
        for (int n : que)
            max = Math.max(max, n);
        int res = nums.length;
        for (int i = 0; i < que.length; i++) {
            if (que[i] == max){
                int r = end[i] - start[i] + 1;
                res = Math.min(r, res);
            }

        }

        return res;
    }
}
