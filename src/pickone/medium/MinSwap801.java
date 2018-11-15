package pickone.medium;

import sun.font.TrueTypeFont;

/**
 * Created by ying on 2018/11/5.
 */
public class MinSwap801 {

    public static void main(String[] args) {
      /* int[] A = {1,3,5,4};
       int[] B ={1,2,3,7};*/
        int[] A = {0,7,8,10,10,11,12,13,19,18};
        int[] B ={4,4,5,7,11,14,15,16,17,20};
        System.out.println(minSwap(A,B));
        for (int i:A)
            System.out.print(i+"\t");
        System.out.println();
        for (int i:B)
            System.out.print(i+"\t");
    }
    public static int minSwap(int[] A, int[] B) {
        if(A.length == 0 || B.length == 0)
            return 0;
        int[] swap = new int[A.length];   //第i个元素表示 AB中第i个元素交换  从0到i的最小交换次数
        int[] keep = new int[A.length];   //第i个元素表示 AB中第i个元素不交换  从0到i的最小交换次数
        swap[0] = 1;
        keep[0] = 0;
        for (int i = 1; i <A.length ; i++) {
            swap[i] = keep[i] = Integer.MAX_VALUE;
            if(A[i]>A[i-1] && B[i]>B[i-1]){    //满足AB不交换的条件
                swap[i] = swap[i-1]+1;         //AB的第i个元素如果交换 则i-1也必须交换
                keep[i] = keep[i-1];           //AB的第i个元素如果不交换，则i-1也不交换
            }
            if(A[i]>B[i-1] && B[i]>A[i-1]){         //满足AB交换的条件
                keep[i]=Math.min(keep[i],swap[i-1]);   //如果第i个元素不交换    则i-1元素必须交换
                swap[i]=Math.min(swap[i],keep[i-1]+1);  //如果第i个元素交换    则i-1元素不交换且加上这一次的交换
            }
        }
        return Math.min(keep[A.length-1],swap[A.length-1]);
    }



}
