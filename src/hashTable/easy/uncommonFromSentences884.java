package hashTable.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ying on 2018/8/24.
 */
public class uncommonFromSentences884 {
    public static void main(String[] args) {
        String A = "this apple is sweet";
        String B = "this apple is sour";
        String[] C = uncommonFromSentences(A, B);
//        System.out.println(C.toString());
        for (String s : C)
            System.out.println(s);
//      getOrDefault()
      /*  HashMap<String,Integer> map = new HashMap<>();
        map.put("key",2);
        map.put("key",5);
        for(String s: map.keySet()){
            System.out.println(s+map.get(s));
        }*/

       /* System.out.println(map.getOrDefault("key",0));
        System.out.println(map.getOrDefault("k",0));*/
    }

    public static String[] uncommonFromSentences(String A, String B) {
//        第一种
       /* String[] astr = A.split(" ");
        String[] bstr = B.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String str : astr) {
            if (map.containsKey(str))
                map.put(str, map.get(str) + 1);
            else
                map.put(str, 1);
        }
        for (String str : bstr) {
            if (map.containsKey(str))
                map.put(str, map.get(str) + 1);
            else
                map.put(str, 1);
        }
        List<String> list = new ArrayList<>();
        for (String str : map.keySet()) {
            if (map.get(str) == 1)
                list.add(str);
        }
        String[] str = new String[list.size()];
        return list.toArray(str);*/
        //    第二种  更简洁
        Map<String, Integer> map = new HashMap<>();
        String[] strs = (A+" "+B).split(" ");
        for (String str : strs){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        List<String> list = new ArrayList<>();
        for (String str : map.keySet()) {
            if (map.get(str) == 1)
                list.add(str);
        }
        String[] str = new String[list.size()];
        return list.toArray(str);
    }

}
