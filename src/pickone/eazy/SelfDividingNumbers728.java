package pickone.eazy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ying on 2019/4/18.
 */
public class SelfDividingNumbers728 {
    public static void main(String[] args) {
        List<Integer> result = selfDividingNumbers(1,22);
        for(Integer i: result)
            System.out.println(i);

    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        if(left < 10 && right >=10){
            for (int i = left; i <10 ; i++) {
                result.add(i);
            }
        }
        for (int i = Math.max(10,left); i <=right ; i++) {
            if(selfhelper(i)){
                result.add(i);
            }
        }
        return result;
    }

    public static boolean selfhelper(int num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - '0';
            if (temp == 0)
                return false;
            if (num % temp != 0)
                return false;
        }
        return true;
    }
}
