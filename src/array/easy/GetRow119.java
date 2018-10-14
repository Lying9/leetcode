package array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/24.
 */
public class GetRow119 {

    public static void main(String[] args) {
        List<Integer> list = getRow(9);
        for(Integer i : list){
            System.out.print(i+ "   ");
        }
    }
    /***
     *思路：：  利用每行的前一个数来计算
     *          规律：每一个元素等于  前一个元素*（本行总元素个数-当前位置前的元素个数）/当前位置前的元素个数
     */
    public  static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        long prev =1;
        for (int i = 1; i <= rowIndex ; i++) {
            prev = (prev*(rowIndex+1-i))/i;
            list.add((int)prev);
        }
        return list;
    }
    /**
     * 思路： 先计算出整个 在返回rowIndex行
     * */
   /* public  static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        for (int i = 1; i <= rowIndex; i++) {
            list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i ; j++) {
                list.add(result.get(i-1).get(j)+result.get(i-1).get(j-1));
            }
            list.add(1);
            result.add(list);
        }
        return result.get(rowIndex);
    }*/
    /**
     * 思路：递归  效率慢 因为好多重复的计算
     */
   /* public  static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex == 0)
            return list;
        list.add(rowIndex);
        if(rowIndex == 1)
            return list;
        int count = rowIndex/2;
        for (int i = 2; i <= count; i++) {
            list.add(computer(rowIndex,i));
        }
        if(rowIndex%2==0){
            while(count > 0) {
                list.add(list.get(--count));
            }
        }
        else{
            while(count >= 0) {
                list.add(list.get(count--));
            }
        }
        return list;
    }

    private static Integer computer(int rowIndex, int i) {
        if(rowIndex == 0 || rowIndex==1 || i==0 || rowIndex == i)
            return 1;
        return computer(rowIndex-1,i)+computer(rowIndex-1,i-1);
    }*/
}
