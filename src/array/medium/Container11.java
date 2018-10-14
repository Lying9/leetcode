package array.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ying on 2018/3/27.
 */
public class Container11 {

    public static void main(String[] args) {
       // int[] height = {5,9,23,6,12,7};
        int[] height = {1,3,2,5,25,24,5};
        System.out.println(maxArea(height));
    }

    //两层循环 Time Limit Exceeded
    /*public static int maxArea(int[] height) {
        int container=0,max = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                container =  (j-i)*Math.min(height[i],height[j]);
                if(container > max)
                    max = container;
            }
        }
        return max;
    }
*/
    //错误，因为treemap  不能用相同的key
   /* public static int maxArea(int[] height) {
        int max = 0;
        Map<Integer,Integer> map = new TreeMap();
        for (int i = 0; i < height.length ; i++) {
            map.put(height[i],i);
        }
        int[] out = new int[height.length];
        for (int i = 0; i < out.length ; i++) {
            out[i] = 0;
        }
        for(Integer h : map.keySet()){
            int low = 0,high = height.length-1,contain;
            while(low<height.length && out[low] == 1)
                low ++;
            while(high >= 0 && out[high] == 1)
                high--;
            contain = Math.max(map.get(h)-low,high-map.get(h))*h;
            if(contain > max)
                max = contain;
            out[map.get(h)] = 1;
        }
        return max;
    }*/

   //先用最左边的一条线和最右边的一条线开始，  每次移动那个height值小的  知道left>=right
    public static int maxArea(int[] height) {
        int max = 0,left = 0,right = height.length -1;
        while(left < right){
            max = Math.max(max,(right-left)*Math.min(height[left],height[right]));
            if(height[left] < height[right])
                left ++;
            else
                right --;
        }

        return max;
    }
}
