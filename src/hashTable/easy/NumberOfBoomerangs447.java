package hashTable.easy;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by ying on 2018/9/14.
 */
public class NumberOfBoomerangs447 {

    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        System.out.println(numberOfBoomerangs(points));


    }
    public static int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i <points.length ; i++) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int j =0; j < points.length ; j++) {
                int dis = (points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                if(map.containsKey(dis))
                    map.put(dis,map.get(dis)+1);
                else
                    map.put(dis,1);
            }
            for(int c:map.values()){
                if(c>=2)
                 count += c*(c-1);
            }
        }
        return  count;
    }
}
