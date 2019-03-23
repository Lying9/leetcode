package bishi;



/**
 * Created by ying on 2019/3/16.
 */


import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l= new int[n];
        int[] d= new int[n];
        for(int i = 0; i < n; i++){
            l[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            d[i] = sc.nextInt();
        }


        if(n == 1) {
            System.out.println(0);
            return;
        }
        else if(n==2){
            int temp = Math.min(d[0],d[1]);
            System.out.println(temp);
            return;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer ss:l){
            int temp = ss;
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            }else
                map.put(temp,1);
        }

        int result = 0,num = n;
        while(map.size() > 0) {
            if(num == 1) {
                System.out.println(result);
                return ;
            }
            Iterator it = map.keySet().iterator();
            int maxvalue = Integer.MIN_VALUE;
            int maxkey = Integer.MIN_VALUE;

            while (it.hasNext()) {
                int temp = (int) it.next();
                if (map.get(temp) > maxvalue) {
                    maxvalue = map.get(temp);
                    maxkey = temp;
                }
            }
            if (n / 2 + n % 2 <= maxvalue) {
                System.out.println(result);
                return;
            }else{
                for (int i = 0; i <l.length ; i++) {
                    if(maxkey == l[i]){
                        result +=d[i];
                        num --;
                    }
                }
                Iterator it1 = map.keySet().iterator();
                while (it1.hasNext()) {
                    int temp = (int) it.next();
                    if (temp == maxkey) {
                       it.remove();
                       break;
                    }
                }
            }
        }




    }

}
