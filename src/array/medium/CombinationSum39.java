package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ying on 2018/4/3.
 */
public class CombinationSum39 {

    public static void main(String[] args) {
       int[] candidates = {2,3,6,7};
       // int[] candidates = {1};
        List<List<Integer>> list = new ArrayList<>();
        list = combinationSum(candidates,7);
        for(List l : list){
            for(Object o : l)
                System.out.print((Integer) o+ "\t");
            System.out.println();
        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        cSum(candidates,target,l,list,0,0);
        return list;
    }
    public static void cSum(int[] condidates,int target, List<Integer> l, List<List<Integer>> list,int sum,int i){
        if(sum == target){
            List<Integer> list1 = new ArrayList<>();
            for(Integer num : l){
                list1.add(num);
            }
            list.add(list1);
            return;
        }
        if(sum > target)
            return;
        for (int j = i; j < condidates.length; j++) {
            l.add(condidates[j]);
            cSum(condidates,target,l,list,sum+condidates[j],j);
            l.remove(l.size()-1);
        }

    }
   /* public static void cSum(int[] condidates,int target, List<Integer> l, List<List<Integer>> list,int sum,int i){
        if(sum + condidates[i] == target){
            l.add(condidates[i]);
            list.add(l);
            l.remove(l.size()-1);
            if(l.size() <= 0)
                return;
            sum = sum - (Integer)l.get(l.size()-1);
            l.remove(l.size()-1);
            i++;
            if(i >= condidates.length)
                return;
            cSum(condidates,target,l,list,sum,i);
        }else if(sum + condidates[i] < target){
            l.add(condidates[i]);
            cSum(condidates,target,l,list,sum+condidates[i],i);
        }else{
            sum = sum - (Integer)l.get(l.size()-1);
            l.remove(l.size()-1);
            i++;
            if(i >= condidates.length)
                return;
            cSum(condidates,target,l,list,sum,i);
        }

    }*/

  /*  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        int right = candidates.length - 1;

        while (right > 0 && candidates[right] > target)
            right--;
        if (candidates[right] == target) {
            List<Integer> l = new ArrayList<>();
            l.add(target);
            list.add(l);
            right--;
        }
        for (int i = 0; i <=right; i++) {
            if(target % candidates[i] == 0){
                List<Integer> l = new ArrayList<>();
                for (int j = 0; j < target/candidates[i] ; j++) {
                    l.add(candidates[i]);
                }
                list.add(l);
            }

            for (int j = i+1 ; j <= right; j++) {
                if (candidates[i] + candidates[j] == target) {
                    List<Integer> l = new ArrayList<>();
                    l.add(candidates[i]);
                    l.add(candidates[j]);
                    list.add(l);
                    right--;
                } else if (candidates[i] + candidates[j] < target) {
                    for (int k = candidates[j]; k < target; k = k + candidates[j]) {
                        List<Integer> l = new ArrayList<>();
                        int count = (target - k) % candidates[i];
                        if (count == 0) {
                            for (int m = 0; m < (target - k) / candidates[i]; m++) {
                                l.add(candidates[i]);
                            }
                            for (int n = 0; n < k / candidates[j]; n++) {
                                l.add(candidates[j]);
                            }
                            list.add(l);
                        }
                    }
                }

            }



        }
        return list;
    }*/
   /* public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        int left = 0,right = candidates.length-1;

        while(right > 0 && candidates[right] >target)
            right--;
        if(candidates[right] == target){
            List<Integer> l = new ArrayList<>();
            l.add(target);
            list.add(l);
            right--;
        }

        while(left < right){
            if(candidates[left] + candidates[right] > target)
                right --;
            else if(candidates[left] + candidates[right] == target){
                List<Integer> l = new ArrayList<>();
                l.add(candidates[left]);
                l.add(candidates[right]);
                list.add(l);
                right --;
            }else{
                //???如果有 可能  则下一步 left和right  应该怎么移动？如果没有又改怎样？？？
                for (int i =candidates[right]; i < target ; i = i+candidates[right]) {
                    List<Integer> l = new ArrayList<>();
                    int count = (target - i)% candidates[left];
                    if(count == 0){
                        for (int j = 0; j < (target - i)/candidates[left] ; j++) {
                            l.add(candidates[left]);
                        }
                        for (int j = 0; j < i/candidates[right] ; j++) {
                            l.add(candidates[right]);
                        }
                        list.add(l);
                    }
                }

                left++;
                right--;
                *//*int sub = candidates[right] - candidates[left];
                if(sub%candidates[right] == 0){
                    List<Integer> l = new ArrayList<>();
                    for (int i = 0; i < sub/candidates[right] ; i++) {
                        l.add(candidates[right]);
                    }
                    l.add(candidates[left]);
                    list.add(l);
                    right
                }*//*
            }

        }
        return list;

    }*/
}
