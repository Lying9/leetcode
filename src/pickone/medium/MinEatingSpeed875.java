package pickone.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by ying on 2018/12/14.
 */
public class MinEatingSpeed875 {
    public static void main(String[] args) {
        int[] piles = {332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184
        };
        int H = 823855818;
        System.out.println(minEatingSpeed(piles, H));
    }

//用二分查找代替1中的查找
    public static int minEatingSpeed(int[] piles, int H) {
        int low = 1, high = 1_000_000_000;
        while (low < high) {
            int mid = (low + high) / 2;
            long hour = 0;
            for (int j = 0; j < piles.length; j++) {
                if (piles[j] % mid == 0)
                    hour += piles[j] / mid;
                else
                    hour += piles[j] / mid + 1;
            }
            if (hour > H)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }



//    time limit exceed
    public static int minEatingSpeed1(int[] piles, int H) {
        if(piles.length == 0)
            return 0;
        Arrays.sort(piles);
        if (piles.length == H)
            return piles[piles.length-1];
        for (int i = 1; i <= piles[piles.length-1]; i++) {
            long hour = 0;
            for (int j = 0; j <piles.length ; j++) {
                if(piles[j] % i == 0)
                    hour += piles[j]/i;
                else
                    hour+= piles[j]/i+1;
            }
            if(hour <= H)
                return i;
        }
        return 0;
    }
}
