package pickone.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ying on 2018/10/19.
 */
public class FindMaxForm474 {
    public static void main(String[] args) {
       /* String[] strs = {"10", "0001", "111001" ,"1", "0"};
       int m =5,n =3;  */  //4


       /* Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               if(o1.length() < o2.length())
                   return -1;
               else if(o1.length() > o2.length())
                   return 1;
               else
                   return 0;
            }
        });*/

        /*String[] strs = {"011","1","11","0","010","1","10","1","1","0","0","0","01111","011","11","00","11","10","1","0","0","0","0","101","001110","1","0","1","0","0","10","00100","0","10","1","1","1","011","11","11","10","10","0000","01","1","10","0"
       };
        int m =44,n =39;  */  //45
        String[] strs = {"111","1000","1000","1000"};
        int m =9,n =3;   //3

        System.out.println(findMaxForm(strs,m,n));
    }
//  动态规划   result[mm][nn][i] 表示有mm个0 nn个1  str中数组的个数为i 所能构成的最大个数
    public static int findMaxForm(String[] strs, int m, int n) {
        int[] mcount = new int[strs.length];
        int[] ncount = new int[strs.length];
        for (int i = 0; i < strs.length ; i++) {
            for(char c : strs[i].toCharArray()){
                if(c == '0')
                    mcount[i]++;
                else
                    ncount[i]++;
            }
        }
        int[][][] result = new int[m+1][n+1][strs.length+1];
        for (int i = 0; i <strs.length ; i++) {
            for(int mm =0 ;mm<m+1;mm++){
                for(int nn = 0;nn<n+1;nn++){
                    if(mcount[i]<=mm && ncount[i]<=nn){
                        result[mm][nn][i+1] = Math.max(result[mm][nn][i],result[mm-mcount[i]][nn-ncount[i]][i]+1);
                    }else
                        result[mm][nn][i+1] = result[mm][nn][i];
                }
            }
        }
        return result[m][n][strs.length];
//        return findMax(strs, 0, m, n,0);
    }

    //time limit exceed   m:0 n:1
//    每一种够的情况 都分为这个数字最后选中和不选
    public static int findMax(String[] strs, int begin, int m, int n,int max) {
        int countone = 0, countzero = 0;
        for (int i = 0; i < strs[begin].length(); i++) {
            if (strs[begin].charAt(i) == '1')
                countone++;
            else
                countzero++;
        }
        if (countone <= n && countzero <= m) {
            if (begin + 1 < strs.length)
                return Math.max(findMax(strs, begin + 1, m - countzero, n - countone,max+1), findMax(strs, begin + 1, m, n,max));
            else
                return max+1;
        } else {
            if (begin + 1 < strs.length)
                return findMax(strs, begin + 1, m, n, max);
            else
                return max;
        }
    }

}
