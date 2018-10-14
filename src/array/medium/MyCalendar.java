package array.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/3/19.
 */
public class MyCalendar {
 /*   private static List<int[]> myCalendars ;
    public MyCalendar(){
        if(myCalendars == null)
            myCalendars = new ArrayList<>();
    }
    public boolean book(int start,int end){
        for(int[] mc : myCalendars){
           // if((mc[0] <= start && start < mc[1])||(mc[0] < end && end < mc[1]))
            if(Math.max(start,mc[0])< Math.min(end,mc[1]))
                return false;
            if(mc.start > end && mc.end<= start)
        }

        myCalendars.add(new int[]{start,end});
        return true;
    }*/

    private static TreeMap map;
    public MyCalendar(){
        map = new TreeMap();
    }
    public boolean book(int start,int end){
        Integer pre = (Integer) map.floorKey(start);
        Integer after = (Integer) map.ceilingKey(start);
        if((pre == null || start>=(int)map.get(pre))&&(after == null || end <= after)){
            map.put(start,end);
            return true;
        }
        return false;
    }
}
