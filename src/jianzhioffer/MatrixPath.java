package jianzhioffer;

/**
 * Created by ying on 2019/3/19.
 */
public class MatrixPath {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAAA";
        char[] matrix = s.toCharArray();
        char[] str = new String("AAAAAAAAAAAA").toCharArray();
        System.out.println(hasPath(matrix, 3, 4, str));
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[] flag = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            boolean temp = helper(matrix, rows, cols, str, i, 0, flag);
            if (temp)
                return true;

        }
        return false;
    }

    public static boolean helper(char[] matrix, int rows, int cols, char[] str, int indexm, int indexs, int[] flag) {

        if (matrix[indexm] != str[indexs])
            return false;
        flag[indexm] = 1;
        indexs++;
        if (indexs >= str.length)
            return true;
        boolean up = false, down = false, left = false, right = false;
        //上
        if (indexm - cols >= 0 && indexm - cols < matrix.length && flag[indexm - cols] == 0) {
            up = helper(matrix, rows, cols, str, indexm - cols, indexs, flag);
        }
        if (up)
            return true;
        //下
        if (indexm + cols >= 0 && indexm + cols < matrix.length && flag[indexm + cols] == 0) {
            down = helper(matrix, rows, cols, str, indexm + cols, indexs, flag);
        }
        if (down)
            return true;
        //左
        if (indexm - 1 >= indexm / cols * cols && flag[indexm - 1] == 0) {
            left = helper(matrix, rows, cols, str, indexm - 1, indexs, flag);
        }
        if (left)
            return true;
        //右
        if (indexm + 1 <= cols * (indexm / cols + 1) - 1 && flag[indexm + 1] == 0)
            right = helper(matrix, rows, cols, str, indexm + 1, indexs, flag);
        if (right)
            return true;
        flag[indexm] = 0;
        return false;
    }


}
