package array.medium;

/**
 * Created by ying on 2018/4/2.
 */
public class Rotate48 {

    public static void main(String[] args) {
        /*int[][] matrix = {{ 5, 1, 9,11},
                        {2, 4, 8,10},
                         {13, 3, 6, 7},
                          {15,14,12,16}};*/
        int[][] matrix = { { 1,2,3},
                {4,5,6},
                {7,8,9}};
        rotate(matrix);
    }
/*
*   思路 ：   在矩阵中 matrix[j][i]的数  会移动到 matrix[i][length-1-j]
 *          我们从数组最外层开始移动  则总共需要移动length/2层     奇数时最后（最里层）剩一个元素 不需再移动
 *
 *          每一层的移动又有这样的规律
 *              matrix[j][i]->matrix[i][length-j-1]->matrix[length-j-1][length-i-1]->matrix[length-i-1][j]->matrix[j][i]
 *          所以我们吧每一层的第一行按这样的规律移动即可
* */
    public static void rotate(int[][] matrix) {
        int temp;
        int length = matrix.length;

        for (int j = 0; j < length/2 ; j++) {
            for (int i = j; i < matrix.length-1-j; i++) {
                temp = matrix[j][i];
                matrix[j][i] =matrix[length-1-i][j];
                matrix[length-1-i][j] = matrix[length-1-j][length-1-i];
                matrix[length-1-j][length-1-i] = matrix[i][length-1-j];
                matrix[i][length-1-j] = temp;
            }

        }



        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();

        }
    }

   /* public static void rotate(int[][] matrix) {
        int temp;
        int length = matrix.length;
        for (int i = 0; i < matrix.length-1; i++) {
            temp = matrix[0][i];
            matrix[0][i] =matrix[length-1-i][0];
            matrix[length-1-i][0] = matrix[length-1][length-1-i];
            matrix[length-1][length-1-i] = matrix[i][length-1];
            matrix[i][length-1] = temp;
        }

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();

        }
    }*/
}
