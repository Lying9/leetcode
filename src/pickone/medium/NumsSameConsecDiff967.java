package pickone.medium;

import java.util.ArrayList;

/**
 * Created by ying on 2019/4/2.
 */
public class NumsSameConsecDiff967 {
    public static void main(String[] args) {
        int[] r = numsSameConsecDiff(3,7);
        for(int i :r)
            System.out.println(i);
    }

    public static int[] numsSameConsecDiff(int N, int K) {
        if(N<=0)
            return null;
        if(N == 1){
            int[] result={0,1,2,3,4,5,6,7,8,9};
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =1;i<10;i++){
            helper(N,K,new StringBuilder(""+i),list);

        }

        int[] result = new int[list.size()];
        for(int i = 0;i<result.length;i++){
            result[i] = list.get(i);
        }
        return result;

    }
    public static void helper(int N,int K,StringBuilder sb,ArrayList list){
        if(sb.length() == N){
            list.add(Integer.valueOf(sb.toString()));
            return;
        }
        int length = sb.length();
        int min= sb.charAt(length-1)-'0'-K;
        if(min >=0 &&min <10){
            sb.append(min);
            helper(N,K,sb,list);
            sb.deleteCharAt(sb.length()-1);
        }
        int max= sb.charAt(length-1)-'0'+K;
        if(max >=0 && max <10){
            sb.append(max);
            helper(N,K,sb,list);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
