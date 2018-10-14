package array.easy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/11/16.
 */
public class ImageSmoother661 {

    public static void main(String[] args) {
        /*int[][] M = new int[][]{{1,1,1},
                                 {1,0,1},
                                 {1,1,1}};*/
      // int[][] M= new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        int[][] M= new int[][]{{6,9,7}};
        int[][] result = imageSmoother(M);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
    /*
    * 思路：1.现对数组进行扩充使其原始数组中每一位周围都有8个数
    *       2.计算这9个数的和
    *       3. 分类   四个角上的的除以4
    *                 四条边但不是角上的除以6
    *                 其余的除以9
    *           特殊情况，1 矩阵只有一个元素，2 矩阵只有一行，                       3  矩阵只有一列
    *                       返回该矩阵      头尾两个元素除以2 剩下除以3              头尾两个元素除以2 剩下除以3
    * */
    public static int[][] imageSmoother(int[][] M) {
        if(M == null)
            return null;
        if(M.length ==1&& M[0].length == 1)
            return M;
        int[][]  m = new int[M.length+2][M[0].length+2];
        int[][] smoother = new int[M.length][M[0].length];
        for (int i = 0; i <m.length ; i++) {
            m[i][0] = 0;
            m[i][m[0].length-1] = 0;
        }
        for (int i = 0; i < m[0].length ; i++) {
            m[0][i] = 0;
            m[m.length-1][i] = 0;
        }
        for (int i = 0; i <M.length ; i++) {
            for (int j = 0; j < M[0].length ; j++) {
                m[i+1][j+1] = M[i][j];
            }
        }
        int sum=0;
        for (int i = 1; i < m.length-1; i++) {
            for (int j = 1; j < m[0].length-1; j++) {
                sum = m[i-1][j-1] + m[i-1][j] +m[i-1][j+1]+m[i][j-1]+m[i][j]+m[i][j+1]+m[i+1][j+1]+m[i+1][j-1]+m[i+1][j];
                if(M.length == 1){
                    if(j==1 || j==m[0].length-2){
                        smoother[i-1][j-1] = sum/2;
                        continue;
                    }
                    smoother[i-1][j-1] = sum/3;
                    continue;
                }
                if(M[0].length == 1){
                    if(i==1 || i==m.length-2){
                        smoother[i-1][j-1] = sum/2;
                        continue;
                    }
                    smoother[i-1][j-1] = sum/3;
                    continue;
                }
                if((i==1&&j==1)||(i==1&&j==m[0].length-2)||(i==m.length-2&&j==1)||(i==m.length-2&&j==m[0].length-2)){
                   smoother[i-1][j-1] = sum/4;
                    continue;
                }
                if(i==1 || j==1 || i==m.length-2 || j==m[0].length-2){
                    smoother[i-1][j-1] = sum/6;
                    continue;
                }
               smoother[i-1][j-1] = sum/9;

            }
        }
        return  smoother;
    }

}
