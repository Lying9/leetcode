package array.medium;

/**
 * Created by ying on 2018/4/8.
 */
public class GenerateMatrix59 {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(0);
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    /* 思路： n=4       1  2   3   4
    *                   12 13  14  5
     *                  11 16  15  6
     *                  10  9   8  7
    *       观察数组可以发现  ：第一行 很简单  对一行赋值后 row=0   col = n-1
    *                           从5 - 7  col不变   而  row每次增1    5-7共n-1个
    *                             8 - 10 col每次减1    row不变       8-10共n-1个
    *                             11-12   col不变      row每次减1    11-12共n-2个
    *                             13-14   col每次增1   row不变       13-14共n-2个
    *                             。。。。                                  1个
    *
    *
    * */

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int row = 0,col =n-1,element = 1;
        //第一行
        for (int i = 0; i < n ; i++) {
            matrix[0][i] = element++;
        }

        int count = n-1,change = 1;
        while(count >0){
            for (int i = 0; i < count; i++) {
                row = row +change;
                matrix[row][col] = element++;
            }
            change = -change;
            for (int i = 0; i < count ; i++) {
                col = col + change;
                matrix[row][col] = element++;
            }
            count--;
        }
        return matrix;

    }
}
