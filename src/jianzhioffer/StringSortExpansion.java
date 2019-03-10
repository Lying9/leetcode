package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by ying on 2019/3/5.
 */
public class StringSortExpansion {
    public static void main(String[] args) {
        ArrayList<String>  result = new ArrayList<>();
        ArrayList<Character>  list = new ArrayList<>();
        String s ="abc";
        helper(result,list,s,0);
        for(String st: result)
            System.out.println(st);
    }
    public static void helper( ArrayList<String>  result,ArrayList<Character>  list,String s,int index){
        if(list.size() >0){
            StringBuilder sb = new StringBuilder();
            for (Character c : list)
                sb.append(c);
            if (!result.contains(sb.toString()))
                result.add(sb.toString());
        }

        for (int i = index; i < s.length(); i++) {
            list.add(s.charAt(i));
            helper(result,list,s,i+1);
            list.remove(list.size()-1);
        }
    }
}
