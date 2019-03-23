package bishi;



/**
 * Created by ying on 2019/3/16.
 */

import java.util.Arrays;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[]  h = new int[n];
        for (int i = 0; i <n ; i++) {
            h[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <n ; i++) {
            min = Math.min(min,h[i]);
        }
        int[] num = new int[n];
        for (int i = 0; i <n ; i++) {
            num[i] = h[i] -min;
        }
        int result = 0;
        Arrays.sort(num);
        int index = 0;
        while(index < n) {
            while (index <n &&num[index] == 0)
                index++;

            for (int i = 0; i < num[n - 1]; i++) {
                int high = 0;
                for (int j = index; j < n; j++) {
                    high += num[j] - i;
                }
                if (high <= k) {
                    result++;
                    for (int j = index; j < n; j++) {
                        num[j] = i;
                    }
                }
            }
        }




        System.out.println(result);

    }
}
