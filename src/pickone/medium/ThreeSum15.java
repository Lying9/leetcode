package pickone.medium;

import java.util.*;

/**
 * Created by ying on 2019/6/16.
 */
public class ThreeSum15 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> list : result)
            System.out.println(list.toString());
    }

    /**
     * 加入了优化
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> tuples = new ArrayList<>();

        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue; //去重

            int l = i+1, r = nums.length-1;
            if(nums[l] < 0 && Integer.MIN_VALUE-nums[l] > nums[i]) continue; //如果溢出最小值则跳过
            if(nums[i] > 0 && Integer.MAX_VALUE-nums[l] < nums[i]) break; //溢出最大值直接结束，不可能会有新的三元组出现了

            while(l < r){
                if(nums[r] > -nums[i]-nums[l]){
                    while(l < r && nums[r-1] == nums[r]) r--; //右指针去重
                    r--;
                }
                else if(nums[r] < -nums[i]-nums[l]){
                    while(l < r && nums[l+1] == nums[l]) l++; //左指针去重
                    l++;
                }
                else{
                    tuples.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l < r && nums[r-1] == nums[r]) r--; //左指针去重
                    while(l < r && nums[l+1] == nums[l]) l++; //右指针去重
                    r--;
                    l++;
                }
            }
        }
        return tuples;

    }



    /*public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        for (int i = 0; i < nums.length; i++) {
            Set<List<Integer>> two = twoSum(nums, i, -nums[i], map);
            for (List<Integer> list : two) {
                List<Integer> l = new ArrayList<>();
                l.add(nums[i]);
                l.addAll(list);
                Collections.sort(l);
                if (!result.contains(l))
                    result.add(l);
            }
        }
        return result;
    }

    private static Set<List<Integer>> twoSum(int[] nums, int i, int target, HashMap<Integer, Integer> map) {
        Set<List<Integer>> result = new HashSet<>();
        if (map.get(nums[i]) == 1)
            map.remove(nums[i]);
        else
            map.put(nums[i], map.get(nums[i]) - 1);
        for (int j = 0; j < nums.length; j++) {
            if (j == i)
                continue;
            int num = target - nums[j];
            if (map.containsKey(num)) {
                if (num == nums[j] && map.get(num) < 2)
                    continue;
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(nums[j]);
                    result.add(list);
                }
            }
        }
        if (map.containsKey(nums[i]))
            map.put(nums[i], map.get(nums[i]) + 1);
        else
            map.put(nums[i], 1);
        return result;
    }*/

    /**
     * 超时
     * 思路：找三个数和为0，相当于 遍历数组，在除去当前位置的数组中找两个数和为某个值的数。
     *
     * @param nums
     * @return
     */
   /* public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length == 0)
            return result;
        Arrays.sort(nums);
        if (nums[0] <= 0 && nums[nums.length - 1] >= 0) {
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] > 0)
                    break;
                Set<List<Integer>> two = twoSum(nums, i, -nums[i]);
                for (List<Integer> list : two) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.addAll(list);
                    if (!result.contains(l))
                        result.add(l);
                }
            }
        }
        return result;
    }

    private static Set<List<Integer>> twoSum(int[] nums, int i, int target) {
        Set<List<Integer>> result = new HashSet<>();
        int begin = i + 1;
        int end = nums.length - 1;
        while (begin < end) {
            if (nums[end] + nums[begin] < target)
                begin++;
            else if (nums[end] + nums[begin] > target)
                end--;
            else {
                List<Integer> list = new LinkedList<>();
                list.add(nums[begin]);
                list.add(nums[end]);
                result.add(list);
                begin++;
                end--;
            }
        }
        return result;
    }*/
}
