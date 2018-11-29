package pickone.medium;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by ying on 2018/11/29.
 */
public class knightDialer935 {
    public static void main(String[] args) {
        System.out.println(knightDialer(161));
    }

    //    思路：  用result来存储当前层的 0  1 。。9各有多少个
//    date 记录的是原始位置分别为0 1.。。9时下一个可能的位置
//    则 要想知道下一层各个位置有几个  ，只需 遍历result数组 在下一个可能的位置上加上result中现在的个数
//    优化：可以用dp
    public static int knightDialer(int N) {
        if (N == 1)
            return 10;
        int mod = 1000000007;
        int[][] date = {{6, 4}, {8, 6}, {7, 9}, {4, 8}, {3, 0, 9}, {}, {1, 0, 7}, {2, 6}, {3, 1}, {2, 4}};
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }
        for (int i = 0; i < N - 1; i++) {
            int[] temp = new int[10];
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < date[j].length; k++) {
                    temp[date[j][k]] = (temp[date[j][k]]+result[j]) % mod;
                }
            }
            result = temp;
        }
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum = (sum + result[i]) % mod;
        }
        return sum;
    }
}
