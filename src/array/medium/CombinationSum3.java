package array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/28.   未解决  递归
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        List<List<Integer>> list = combinationSum3(3,7);
        for(List  l : list){
            for(Object i : l){
                System.out.print((int)i+"   ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        int maxSum = 0,sum = 0;
        for (int i = 1; i <9 ; i++) {
            maxSum += i;
        }
        if(n > maxSum || k >9)
            return null;
        List<List<Integer>> list = new ArrayList<List<Integer>>() ;
        List<Integer> list1 = new ArrayList<>();
        if(maxSum == n){
            if(k == 9) {
                for (int i = 1; i < 9; i++) {
                    list1.add(i);
                }
                list.add(list1);
                return list;
            }
            else
                return null;
        }
        for (int i = 0; i <k-2 ; i++) {
            list1.add(i);
            sum += i;
        }
        for (int i = k-2; i >=0; i--) {
            //i = k-2时
            if(n - sum > list1.get(i)) {
                list1.add(n - sum);
                list.add(list1);
            }

        }


        return null;
    }
}
