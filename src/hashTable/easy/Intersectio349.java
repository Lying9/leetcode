package hashTable.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ying on 2018/9/11.
 */
public class Intersectio349 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7,8,9};
        int[] nums2 = {3,4,5,9,10};
        int[] result = intersection(nums1,nums2);
        for(int i : result) {
            System.out.println(i);
        }

    }
    public static  int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        Set<Integer> result= new HashSet<>();
        for(int i : nums1){
            s.add(i);
        }
        for(int i: nums2){
            if(s.contains(i))
                result.add(i);
        }
        int[] inter = new int[result.size()];
        int j = 0;
        for(int i : result){
            inter[j++] = i;
        }
        return inter;
    }
}
