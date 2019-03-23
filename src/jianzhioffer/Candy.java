package jianzhioffer;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by ying on 2019/3/16.
 */
public class Candy {

    public static void main(String[] args){
        String kid= "1 2 3";
        String candy = "1 1";

        TreeMap<Integer,Integer> kidmap = new TreeMap<>();
        TreeMap<Integer,Integer> candymap = new TreeMap<>();

        String[] kids = kid.split(" ");
        for(int i = 0;i< kids.length;i++){
            int temp=Integer.valueOf(kids[i]);
            if(kidmap.containsKey(temp))
                kidmap.put(temp,kidmap.get(temp)+1);
            else
                kidmap.put(temp,1);
        }

        String[] candys = candy.split(" ");
        for(int i = 0;i< candys.length;i++){
            int temp=Integer.valueOf(candys[i]);
            if(candymap.containsKey(temp))
                candymap.put(temp,candymap.get(temp)+1);
            else
                candymap.put(temp,1);
        }
            int count = 0;
        while(candymap.size()>0 && kidmap.size()>0){
            Map.Entry<Integer,Integer>  entryc = candymap.lastEntry();
            int c = entryc.getKey();
            int cv = entryc.getValue();
            Map.Entry<Integer,Integer>  entryk = kidmap.lastEntry();
            int k = entryk.getKey();
            int kv = entryk.getValue();
            if(c >k){
                if(cv > kv){
                    count += kv;
                    candymap.put(c,cv-kv);
                    kidmap.remove(k);
                }else if(cv< kv){
                    count += cv;
                    kidmap.put(k,kv-cv);
                    candymap.remove(c);
                }else{
                    count += kv;
                    kidmap.remove(k);
                    candymap.remove(c);
                }
            }else if(c==k){
                if(cv > kv){
                    count += kv;
                    candymap.put(c,cv-kv);
                    kidmap.remove(k);
                }else {
                    count += cv;
                    kidmap.remove(k);
                    candymap.remove(c);
                }
            }else{
                kidmap.remove(k);
            }
        }
        System.out.println(count);
    }
}
