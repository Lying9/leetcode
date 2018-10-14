package pickone.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ying on 2018/9/26.
 */
public class FindMinDifference539 {
    public static void main(String[] args) {
//    List<String> timepoints = Arrays.asList("12:01","00:10","00:01");   //9
        List<String> timepoints = Arrays.asList("05:31", "22:08", "00:35");
        System.out.println(findMinDifference(timepoints));
    }

    //    两两比较   time limit exceed
  /*  public  static int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() ; i++) {
            for (int j = i+1; j < timePoints.size() ; j++) {
                String[] time1 = timePoints.get(i).split(":");
                String[] time2 = timePoints.get(j).split(":");
//                hour
                int hour1 = Integer.parseInt(time1[0]);
                int minu1 = Integer.parseInt(time1[1]);
                int hour2 = Integer.parseInt(time2[0]);
                int minu2 = Integer.parseInt(time2[1]);
                int diff1 = 0,diff2=0;
                if(hour1 == 0 && minu1 == 0)
                    hour1 = 24;
                if(hour2 == 0 && minu2 == 0)
                    hour2 = 24;
                if(hour1 > hour2){
                         diff1 = (minu1-minu2)+(hour1 - hour2)*60;
                         diff2 = (minu2 - minu1)+(hour2+24-hour1)*60;
                }else {
                    diff1 = Math.abs((minu2 - minu1) + (hour2 - hour1) * 60);
                    diff2 = Math.abs((minu1 - minu2) + (hour1+24 - hour2) * 60);
                }
                min = Math.min(diff1,min);
                min = Math.min(diff2,min);
            }
        }
        return min;
    }*/
//  accept 先对时间进行排序  在比较相邻的两个元素之间的差
//    可以改进的地方     1.可直接存储时间所表示的分钟数  2.可用一个Boolean类型的数组来表示该下标所对应的分钟数是否存在。然后遍历该数组 便可得到最小时间差（省去了排序的时间）
    public static int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        Collections.sort(timePoints);
        int[] hour = new int[timePoints.size()];
        int[] minu = new int[timePoints.size()];
        for (int i = 0; i <timePoints.size() ; i++) {
            String[] time = timePoints.get(i).split(":");
            hour[i] = Integer.parseInt(time[0]);
            minu[i] = Integer.parseInt(time[1]);
        }
        int diff;
        for (int i = 0; i <timePoints.size()-1; i++) {
            diff = (minu[i+1]-minu[i])+(hour[i+1]-hour[i])*60;
            min = Math.min(min,diff);
        }
        diff = (minu[0] - minu[timePoints.size()-1])+(hour[0]+24-hour[timePoints.size()-1])*60;
        min = Math.min(min,diff);
        return min;
    }
}
