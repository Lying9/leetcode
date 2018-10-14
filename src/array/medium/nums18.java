package array.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ying on 2018/4/12.
 */
public class nums18 {
    public static void main(String[] args) {
      /* int[] nums ={5,5,3,5,1,-5,1,-2};
        int target = 4;*/
        int[] nums = {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
        int target = 0;
       /* int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;*/
       /* int[] nums = {-1,0,1,2,-1,-4};
        int target = -1;*/
        List<List<Integer>> list = fourSum(nums,target);
        for (List<Integer> l : list){
            for (Integer i : l){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }

    public  static  List<List<Integer>> fourSum(int[] nums, int target){
        int k =4;
        List<List<Integer>>  result = new ArrayList<>();
        if(nums == null || nums.length < k || k<2)
            return result;
        Arrays.sort(nums);
        kSum_Trim(nums,target,k,0,result,new ArrayList<>());
        return result;
    }

    static  void kSum_Trim(int[] nums, int target, int k, int start, List<List<Integer>> result, List<Integer> path) {
        int max = nums[nums.length-1];
        if(nums[start]*k >target || max*k< start)
            return;
        if(k==2){
            int left = start,right = nums.length-1;
            while(left < right){
                if(nums[left]+nums[right] > target)
                    right--;
                else if(nums[left] + nums[right] < target)
                    left++;
                else{
                    /*path.add(nums[left]);
                    path.add(nums[right]);
                    List<Integer> list = new ArrayList<>();
                    list.addAll(path);
                    result.add(list);*/
                    //不能在path里直接添加 因为会影响后面的操作
                    result.add(new ArrayList<>(path));
                    result.get(result.size()-1).addAll(Arrays.asList(nums[left],nums[right]));

                    left++;
                    right--;
                    while(left<right && nums[left] == nums[left-1])
                        left++;
                    while(left < right && nums[right] == nums[right+1])
                        right--;
                }
            }
        }
        else{
            for (int i = start; i < nums.length-k+1 ; i++) {
                if(i>start && nums[i] == nums[i-1]) continue;
                if(nums[i] + max*(k-1) < target) continue;
                if(nums[i] *k >target) break;
                if(nums[i] *k == target){
                    if(nums[i+k-1] == nums[i]){
                        result.add(new ArrayList<>(path));
                        List<Integer> list = new ArrayList<>();
                        for (int j = 0; j < k ; j++) {
                            list.add(nums[i]);
                        }
                        result.get(result.size()-1).addAll(list);
                    }
                    break;
                }
                path.add(nums[i]);
                kSum_Trim(nums,target - nums[i],k-1,i+1,result,path);
                path.remove(path.size()-1);

            }
        }

    }

   /* public  static  List<List<Integer>> fourSum(int[] a, int target) {
        int k = 4;
        List<List<Integer>> result = new ArrayList<>();
        if (a == null || a.length < k || k < 2) return result;
        Arrays.sort(a);
        kSum_Trim(a, target, k, 0, result, new ArrayList<>());
        return result;
    }

   static  void kSum_Trim(int[] a, int target, int k, int start, List<List<Integer>> result, List<Integer> path) {
        int max = a[a.length - 1];
        if (a[start] * k > target || max * k < target) return;

        if (k == 2) {                        // 2 Sum
            int left = start;
            int right = a.length - 1;
            while (left < right) {
                if (a[left] + a[right] < target) left++;
                else if (a[left] + a[right] > target) right--;
                else {
                    result.add(new ArrayList<>(path));
                    result.get(result.size() - 1).addAll(Arrays.asList(a[left], a[right]));
                    left++;
                    right--;
                    while (left < right && a[left] == a[left - 1]) left++;
                    while (left < right && a[right] == a[right + 1]) right--;
                }
            }
        } else {                        // k Sum
            for (int i = start; i < a.length - k + 1; i++) {
                if (i > start && a[i] == a[i - 1]) continue;
                if (a[i] + max * (k - 1) < target) continue;
                if (a[i] * k > target) break;
                if (a[i] * k == target) {
                    if (a[i + k - 1] == a[i]) {
                        result.add(new ArrayList<>(path));
                        List<Integer> temp = new ArrayList<>();
                        for (int x = 0; x < k; x++) temp.add(a[i]);
                        result.get(result.size() - 1).addAll(temp);    // Add result immediately.
                    }
                    break;
                }
                path.add(a[i]);
                kSum_Trim(a, target - a[i], k - 1, i + 1, result, path);
                path.remove(path.size() - 1);        // Backtracking
            }
        }
    }*/
//循环   双指针
   /* private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>  list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length -3 ; i++) {
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            for (int j = i+1; j < nums.length-2 ; j++) {
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;

                int k = j+1;
                int l = nums.length-1;
                while(k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l] < target){
                        k++;
                    }else if(nums[i]+nums[j]+nums[k]+nums[l] > target){
                        l--;
                    }else{
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[k]);
                        li.add(nums[l]);

                        k++;
                        l--;

                        list.add(li);
                        while(k<l && nums[k]== nums[k-1])
                            k++;
                        while(k<l && nums[l] == nums[l+1])
                            l--;
                    }
                }
            }
        }
        return list;
    }*/

//dfs   Time limit exceeded
 /*   public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        dfs(list,l,0,nums,target,0);
        return list;
    }
    public static void dfs(List<List<Integer>> list ,List<Integer> l ,int sum,int[] nums,int target,int index){
        if(sum == target && l.size()==4){
            List<Integer> ll = new ArrayList<>();
            for (int i = 0; i < l.size() ; i++) {
                ll.add(l.get(i));
            }
            list.add(ll);
            return;
        }
        if(l.size()==4 && sum != target)
            return;
        if(l.size()>4)
            return;
        for (int i = index; i < nums.length ; i++) {
            l.add(nums[i]);
            dfs(list,l,sum+nums[i],nums,target,i+1);

           while(i+1<nums.length && l.get(l.size()-1) == nums[i+1])
                i++;

            l.remove(l.size()-1);

        }


    }*/
}
