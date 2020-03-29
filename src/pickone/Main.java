package pickone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ying on 2019/8/15.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer,Integer> map1 = new HashMap() ;
        HashMap<Integer,Integer> map2 = new HashMap();
        for (int i = 0; i <n ; i++) {
            int temp = sc.nextInt();
            if(map1.containsKey(temp)){
                map1.put(temp,map1.get(temp)+1);
            }else
                map1.put(temp,1);
        }
        for (int i = 0; i <n ; i++) {
            int temp = sc.nextInt();
            if(map2.containsKey(temp)){
                map2.put(temp,map1.get(temp)+1);
            }else
                map2.put(temp,1);
        }
        int  mod = m-1;
        ArrayList<Integer> list = new ArrayList();
        for (int i = mod; i >=0 ; i--) {
            for(Integer key : map1.keySet()){
                if(map2.containsKey(mod-key)){
                    list.add(mod);

                }
            }
        }



    }

    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n  = sc.nextInt();
        int m = sc.nextInt();
        int[][] count = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                count[i][j] = sc.nextInt();
            }
        }

        int sum = 0;
        int z = 0;
        int a[][] = new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                z += count[i][j];
                int temp = 0;
                if(i-1>=0){
                    temp += Math.min(count[i][j],count[i-1][j]);
                }
                if(j-1>=0){
                    temp += Math.min(count[i][j],count[i][j-1]);
                }
                if(i+1 < n)
                    temp += Math.min(count[i][j],count[i+1][j]);
                if(j+1<m)
                    temp += Math.min(count[i][j],count[i][j+1]);
                sum = sum+ temp + 2*(count[i][j]-1);
                a[i][j] = temp+ 2*(count[i][j]-1);
            }
        }
        System.out.println(6*z-sum);
    }
}
