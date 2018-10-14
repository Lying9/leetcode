package array.easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
public class Generate118 {

    public static void main(String[] args) {
        List<List<Integer>> list = generate(0);
        for (List<Integer> li : list){
            Iterator it = li.iterator();
            while(it.hasNext()){
                System.out.print(it.next()+"   ");
            }
            System.out.println();
        }
    }

/*
*  第n行有n个数
*  除第一行第二行外  其他每行 除第一个和最后一个数外  都为上一行的两个数之和
* */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0)
            return result;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i ; j++) {
                list.add(result.get(i-1).get(j)+result.get(i-1).get(j-1));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}
