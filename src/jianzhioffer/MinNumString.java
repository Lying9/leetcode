package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ying on 2019/3/7.
 */
public class MinNumString {

    public static void main(String[] args) {
//        System.out.println(compare(323,32123));
        int[] nums = {3,323,32123};
        System.out.println(PrintMinNumber(nums));
    }

    public static String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i: numbers)
            list.add(i);
        Collections.sort(list,new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                String sa = Integer.toString(a);
                String sb = Integer.toString(b);
                if(sa.length() == sb.length())
                    return Integer.compare(a,b);
                int length = Math.min(sa.length(),sb.length());
                int i = 0;
                for(i = 0;i<length;i++){
                    if(sa.charAt(i) > sb.charAt(i))
                        return 1;
                    else if(sa.charAt(i) < sb.charAt(i))
                        return -1;
                }
                if(sa.length() > sb.length()){
                    if(sa.charAt(i) > sa.charAt(i-1))
                        return 1;
                    else
                        return -1;
                }else {
                    if(sb.charAt(i) > sb.charAt(i-1))
                        return 1;
                    else
                        return -1;
                }
            }
        });

        StringBuilder sb =new StringBuilder();
        for(Integer in :list){
            sb.append(Integer.toString(in));
        }
        return sb.toString();
    }

        public static int compare(Integer a,Integer b){
            String sa = Integer.toString(a);
            String sb = Integer.toString(b);
            if(sa.length() == sb.length())
                return Integer.compare(a,b);
            int length = Math.min(sa.length(),sb.length());
            int i = 0;
            for(i = 0;i<length;i++){
                if(sa.charAt(i) > sb.charAt(i))
                    return 1;
                else if(sa.charAt(i) < sb.charAt(i))
                    return -1;
            }
            if(sa.length() > sb.length()){
                if(sa.charAt(i) > sa.charAt(i-1))
                    return -1;
                else
                    return 1;
            }else {
                if(sb.charAt(i) > sb.charAt(i-1))
                    return -1;
                else
                    return 1;
            }
        }

}
