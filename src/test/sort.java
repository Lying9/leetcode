package test;

/**
 * Created by ying on 2018/12/27.
 */
public class sort {
    public static void main(String[] args) {
        //   int[] a = {0, 6, 9, 2, 5, 12, 56, 32, 1, 89};
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
//        希尔排序
        int dk = a.length / 2;
        while (dk >= 1) {
            shellInsertsort(a, a.length, dk);
            dk = dk / 2;
        }
//      二分选择排序
       /* SelectSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }*/
    }

    //希尔排序
    public static void shellInsertsort(int a[], int n, int dk) {
        for (int i = dk ; i < n; i++) {
            if (a[i] < a[i - dk]) {
                int x = a[i];
                int j = i - dk;
                while (j >= 0 && x < a[j]) {
                    a[j + dk] = a[j];
                    j -= dk;
                }
                a[j + dk] = x;
            }
        }
    }


    public static void SelectSort(int r[], int n) {
        int i, j, min, max, temp;
        for (i = 0; i < n / 2; i++) {
            // 做不超过n/2趟选择排序
            min = i;
            max = i; //分别记录最大和最小关键字记录位置
            for (j = i + 1; j <= n - i - 1; j++) {
                if (r[j] > r[max]) {
                    max = j;
                    continue;
                }
                if (r[j] < r[min]) {
                    min = j;
                }
            }
//            最小值是否已经在正确的位置上了
            if (min != i) {
                temp = r[min];
                r[min] = r[i];
                r[i] = temp;
            }
//            可能出现最大值存储在r[i]的位置经过前面的变换，最大值换到了r[min]的位置
            if (max == i)
                max = min;
//            最大值是否已经在正确的位置上
            if (max != n - i - 1) {
                temp = r[max];
                r[max] = r[n - i - 1];
                r[n - i - 1] = temp;
            }

        }

    }
}
