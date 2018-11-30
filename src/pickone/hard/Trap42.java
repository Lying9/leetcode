package pickone.hard;

/**
 * Created by ying on 2018/11/30.
 */
public class Trap42 {
    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};   //6
        int[] height = {4, 2, 3};   //1
        System.out.println(trap(height));
    }

    //动态规划： 就是将左边最大，和右边最大先存储在一个数组中
//    时间复杂度o(n)  空间复杂度o(n)
    public static int trap(int[] height) {
        if(height.length == 0)
            return 0;
        int result = 0;
        int[] maxLeft = new int[height.length],maxRight = new int[height.length];
        maxLeft[0] = height[0];
        maxRight[height.length-1] = height[height.length-1];
        for (int i = 1; i <height.length ; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1],height[i]);
        }
        for (int i = height.length-2; i>=0 ; i--) {
            maxRight[i] = Math.max(maxRight[i+1],height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            result+= Math.min(maxLeft[i],maxRight[i])-height[i];
        }
        return result;
    }
//思想：当前柱子能存水的单元 等于 两侧的柱子的最大高度 减去 自身高度 的最小值
//    时间复杂度O（n * n） 空间复杂度 o(1)
    public static int trap2(int[] height) {
        int result = 0;
        for (int i = 1; i <height.length-1 ; i++) {
            int maxLeft = 0;
            for (int j = 0; j <= i ; j++) {
                maxLeft = Math.max(maxLeft,height[j]);
            }
            int maxRight = 0;
            for (int j = i; j <height.length ; j++) {
                maxRight = Math.max(maxRight,height[j]);
            }
            result += Math.min(maxLeft,maxRight)-height[i];
        }
        return  result;
    }

/*
思想 ： 当前位置往后 能够存水的地方 是后面有比该位置水位高的位置，能够存水的地方是该位置 与 比该位置水位高的位置 之间
                                    后面没有比该位置高的水位时，能够存水的地方是该位置 与 该位置后水位最高的位置 之间
时间复杂度 o(n * n) n:height的长度   空间复杂度：o（1）
* */
    public static int trap1(int[] height) {
        int i = 0, result = 0;
        while (i < height.length) {
            int j;
            for (j = i + 1; j < height.length; j++) {
                if (height[j] >= height[i])
                    break;
            }
//            后面有比height[i]大的数
            if (j < height.length) {
//                i和j之间有空隙
                if (j - i > 1) {
                    int high = Math.min(height[i], height[j]);
                    int sum = 0;
                    for (int k = i + 1; k < j; k++) {
                        sum += high - height[k];
                    }
                    result += sum;
                }
                i = j;
            } else {
//                如果后面没有比height[i]大的数，则考虑i与后面最大的数之间的unit
                int max = -1, maxIndex = -1, k;
                for (k = i + 1; k < height.length; k++) {
                    if (height[k] > max) {
                        max = height[k];
                        maxIndex = k;
                    }
                }
//               如果maxindex为-1，则表示i已经为height.length-1了
                if(maxIndex > -1) {
                    int sum = 0;
                    if (maxIndex - i > 1) {
                        for (int l = i + 1; l < maxIndex; l++) {
                            sum += max - height[l];
                        }
                        result += sum;
                    }
                    i = maxIndex;
                }else
                    break;
            }
        }
        return result;
    }
}
