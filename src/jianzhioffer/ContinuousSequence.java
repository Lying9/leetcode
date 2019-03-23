package jianzhioffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by ying on 2019/3/13.
 */
public class ContinuousSequence {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = FindContinuousSequence(1);
        for(ArrayList<Integer> list : result){
            for(Integer i:list)
                System.out.print(i+"\t");
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        int  presum = 0;
        int begin = 1,end = 1;
        while(end <= sum){
            if(presum < sum){
                presum += end;
                end++;
            }else if(presum > sum){
                presum -= begin;
                begin++;
            }else{
                if(end - begin >=2){
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int i=begin;i<end;i++)
                        list.add(i);
                    result.add(list);
                    presum -= begin;
                    begin++;
                }
            }
        }
        return result;
    }
}
