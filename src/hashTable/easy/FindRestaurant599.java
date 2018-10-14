package hashTable.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ying on 2018/9/18.
 */
public class FindRestaurant599 {
    public String[] findRestaurant1(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                int sum = i+map.get(list2[i]);
                if(sum < min){
                    list.clear();
                    list.add(list2[i]);
                    min = sum;
                }else if(sum == min)
                    list.add(list2[i]);
            }

        }
        return list.toArray(new String[list.size()]);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> dupmap = new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i]))
                dupmap.put(list2[i],map.get(list2[i])+i);
        }
        int min = Integer.MAX_VALUE;
        for(Integer i : dupmap.values()){
            min = Math.min(min,i);
        }
        List<String> list = new ArrayList<>();
        for(String s:dupmap.keySet()){
            if(dupmap.get(s) == min)
                list.add(s);
        }
        return list.toArray(new String[list.size()]);
    }
}
